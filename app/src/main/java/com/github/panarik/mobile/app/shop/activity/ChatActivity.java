package com.github.panarik.mobile.app.shop.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.github.panarik.mobile.app.shop.R;
import com.github.panarik.mobile.app.shop.data.chat.ChatMessage;
import com.github.panarik.mobile.app.shop.data.chat.ChatMessageAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

    //БД Firebase
    FirebaseDatabase database;
    DatabaseReference messagesDatabaseReference;
    DatabaseReference usersDatabaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //инициализируем БД Firebase
        database = getInstance();
        //инициализируем узел в БД
        messagesDatabaseReference = database.getReference().child("messages");
        //прослушиваем ДБ на изменения
        ChildEventListener messagesChildEventListener;

        userName = "User";
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
                        {
                                new InputFilter.LengthFilter(500)
                        }
                );


        chat_messageSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //собираем текст
                ChatMessage message = new ChatMessage();
                message.setText(chat_messageEditText.getText().toString());
                message.setName(userName);
                message.setImageUrl(null);

                //отправляем на сервер с помощью .push()
                messagesDatabaseReference.push().setValue(message);


                chat_messageEditText.setText("");
            }
        });


        chat_messageSendPhotoImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        //прослушаваем различные изменения БД
        messagesChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                //получаем снимок (snapshot)
                ChatMessage message = snapshot.getValue(
                        //указываем где распознавать значения
                        ChatMessage.class);
                //итого, получаем объект с полями, и устанавливаем его в Адаптер
                adapter.add(message);
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
}
