package com.github.panarik.smartFeatures.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.data.chat.ChatMessage;
import com.github.panarik.smartFeatures.data.chat.ChatMessageAdapter;
import com.github.panarik.smartFeatures.data.chat.ChatUser;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import static com.google.firebase.database.FirebaseDatabase.getInstance;

import java.util.ArrayList;
import java.util.List;


public class ChatActivity extends AppCompatActivity {

    private ListView messageListView;
    private ChatMessageAdapter adapter;
    private ProgressBar progressBar;
    private ImageButton chat_messageSendPhotoImageButton;
    private Button chat_messageSendButton;
    private EditText chat_messageEditText;
    private String userName;

    private String recipientUserId; //UserId выбранного пользователя из UserListActivity (кому пишем сообщение)

    private static final int RequestCode_IMAGE = 1;

    //Auth Firebase
    private FirebaseAuth auth; //текущий пользователь данной сессии
    //БД Firebase
    private FirebaseDatabase database;
    private DatabaseReference messagesDatabaseReference; //БД сообщений
    private DatabaseReference usersDatabaseReference; //БД пользователей
    //прослушиваем изменения БД
    private ChildEventListener messagesChildEventListener; //слушаем узел сообщений
    private ChildEventListener usersChildEventListener; //слушаем узел пользователей

    //Firebase storage
    private FirebaseStorage storage;
    //Прослушивание изменений storage
    private StorageReference chatImageStorageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //получаем текущего пользователя для данной сессии
        auth = FirebaseAuth.getInstance();


        //принимаем данные с интентом при открытии активити
        Intent intent = getIntent();
        if (intent != null) {
            userName = intent.getStringExtra("userName"); // получаем имя пользователя
            recipientUserId = intent.getStringExtra("recipientUserId"); // получаем id пользователя
        } else {
            userName = "Default User";
        }


        //Firebase
        database = getInstance(); //инициализируем БД Firebase
        storage = FirebaseStorage.getInstance(); //инициализируем Firebase storage

        //инициализируем узлы в БД
        messagesDatabaseReference = database.getReference().child("messages");
        usersDatabaseReference = database.getReference().child("users");
        //инициализируем узел в storage
        chatImageStorageReference = storage.getReference().child("/chat_images");

        progressBar = findViewById(R.id.progressBar);
        messageListView = findViewById(R.id.messageListView);
        chat_messageSendPhotoImageButton = findViewById(R.id.chat_messageSendPhotoImageButton);
        chat_messageSendButton = findViewById(R.id.chat_messageSendButton);
        chat_messageEditText = findViewById(R.id.chat_messageEditText);


        //создаем новый адаптер и передаем ему ArrayList
        List<ChatMessage> chatMessages = new ArrayList<>();
        adapter = new ChatMessageAdapter(this, R.layout.chat_message_item, chatMessages);
        messageListView.setAdapter(adapter);

        //изначально progressBar невидим
        progressBar.setVisibility(ProgressBar.INVISIBLE);

        //прошлушиваем ввод текста для отображения кнопки "Отправить"
        chat_messageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() > 0) {
                    chat_messageSendButton.setEnabled(true);
                } else {
                    chat_messageSendButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        //ограничиваем длину сообщения
        chat_messageEditText.setFilters
                (new InputFilter[]
                        {new InputFilter.LengthFilter(500)}
                );


        chat_messageSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //собираем текст
                ChatMessage message = new ChatMessage();
                message.setText(chat_messageEditText.getText().toString());
                message.setName(userName);
                message.setSender(auth.getCurrentUser().getUid()); //получаем id текущего пользователя (отправитель сообщения)
                message.setRecipient(recipientUserId); //получаем id выбранного в UserList пользователя (получатель сообщения)
                message.setImageUrl(null);

                //отправляем на сервер с помощью .push()
                messagesDatabaseReference.push().setValue(message);

                chat_messageEditText.setText("");
            }
        });


        //загрузка фото в чат
        chat_messageSendPhotoImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT); // получение контента
                intent.setType("image/jpeg"); //тип контента (изображения, все виды)
                intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true); //источник контента

                startActivityForResult(
                        Intent.createChooser(intent, "Choose some image"), //создаем активити выбираем
                        RequestCode_IMAGE) //код запроса для получения и проверки результата
                ;
            }
        });


        //прослушаваем изменения в БД (узел юзеров)
        usersChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                //получаем всех пользователей
                ChatUser user = snapshot.getValue(ChatUser.class);
                //находим нужного пользователя (сравниваем текущего с БД)
                if (user.getUserId()
                        .equals(
                                FirebaseAuth.getInstance().getCurrentUser().getUid())) {
                    userName = user.getUserName();
                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };

        //прикрепляем listener к БД users
        usersDatabaseReference.addChildEventListener(usersChildEventListener);


        //прослушаваем изменения в БД (узел сообщений)
        messagesChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                //получаем снимок (snapshot)
                ChatMessage message = snapshot.getValue(
                        //указываем где распознавать значения
                        ChatMessage.class);

                //проверяем сообщения:
                if (
                        message.getSender().equals(auth.getCurrentUser().getUid()) //если отправитель сообщения = текущий пользователь
                                &&
                                message.getRecipient().equals(recipientUserId) //если получатель сообщения = выбранный в UserList пользователь
                                ||
                                message.getRecipient().equals(auth.getCurrentUser().getUid()) //если получатель сообщения = текущий пользователь
                                        &&
                                        message.getSender().equals(recipientUserId) //если отправитель сообщения = выбранный в UserList пользователь
                ) {
                    // то добавляем в адаптер (отображаем) сообщение
                    // получаем объект с полями, и устанавливаем его в Адаптер
                    adapter.add(message);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };

        //прикрепляем listener к БД messages.
        messagesDatabaseReference.addChildEventListener(messagesChildEventListener);

    }


    //активация меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    //пункты меню
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.main_sign_out:
                //выйти из учетной записи
                FirebaseAuth.getInstance().signOut();
                //переход на экран авторизации
                Intent goToSignInActivity = new Intent(ChatActivity.this, SignInActivity.class);
                startActivity(goToSignInActivity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void goToMainActivity(View view) {
        Intent goToMainActivity = new Intent(this, MainActivity.class);
        startActivity(goToMainActivity);
    }

    //получаем адрес изображения, выбранного по кнопке chat_messageSendPhotoImageButton
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RequestCode_IMAGE //адреса запроса совпадают
                &&
                resultCode == RESULT_OK) //выбор изображения успешен
        {
            Uri selectedImageUri = data.getData();
            //создаем новую ссылку в storage (последний сегмент в ссылке)
            final StorageReference imageReference = chatImageStorageReference
                    .child(selectedImageUri.getLastPathSegment());

            //загружаем изображение в storage
            UploadTask uploadTask = imageReference.putFile(selectedImageUri);

            //Get download URL from Firebase
            //скопировано из источника: https://firebase.google.com/docs/storage/android/upload-files
            uploadTask = imageReference.putFile(selectedImageUri);

            Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful()) {
                        throw task.getException();
                    }

                    // Continue with the task to get the download URL
                    return imageReference.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()) {
                        Uri downloadUri = task.getResult();
                        ChatMessage message = new ChatMessage();
                        message.setImageUrl(downloadUri.toString());
                        message.setName(userName); //устанавливаем имя
                        message.setSender(auth.getCurrentUser().getUid()); //устанавливаем и отправляем id отправителя
                        message.setRecipient(recipientUserId); //устанавливаем и отправляем id получателя
                        messagesDatabaseReference.push().setValue(message); //отправляем сообщение в БД
                    } else {
                        // Handle failures
                        // ...
                    }
                }
            });


        }
    }
}
