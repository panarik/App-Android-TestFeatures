package com.github.panarik.smartFeatures.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.data.chat.ChatUser;
import com.github.panarik.smartFeatures.data.userlist.UserlistUserAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_CALL = 1;
    private String userName; //userName из SingIn (дописать из MainActivity тоже)

    private DatabaseReference usersDatabaseReference;
    private ChildEventListener usersChildEventListener;

    private ArrayList<ChatUser> userArrayList;
    private RecyclerView userRecyclerView;
    private UserlistUserAdapter userlistUserAdapter;
    private RecyclerView.LayoutManager userLayoutManager;

    //текущий пользователь
    private FirebaseAuth auth;

    //для отправки набранного намера в телефон
    private EditText callNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);

        callNumber = findViewById(R.id.userlist_call_EditText);

        //принимаем данные с интентом при открытии активити
        Intent intent = getIntent();
        if (intent != null) {
            userName = intent.getStringExtra(userName);
        }


        //получаем id текущего пользователя
        auth = FirebaseAuth.getInstance();

        userArrayList = new ArrayList<>();

        //наполняем userArrayList
        attachUserDatabaseReferenceListener();

        buildRecyclerView();
    }


    private void attachUserDatabaseReferenceListener() {
        usersDatabaseReference = FirebaseDatabase.getInstance().getReference().child("users");
        if (usersChildEventListener == null) {
            usersChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    ChatUser user = dataSnapshot.getValue(ChatUser.class); //получение пользователя

                    //проверка, показываем пользователей кроме текущего
                    if (! // не равно
                            user.getUserId()
                                    .equals(auth.getCurrentUser().getUid()))  //строки сравниваем с помощью метода .equals()
                    {
                        //добавление пользователей в ArrayList
                        user.setAvatarMockUpResource(R.drawable.ic_userlist_baseline_person_24);
                        userArrayList.add(user);
                        userlistUserAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            };

            usersDatabaseReference.addChildEventListener(usersChildEventListener);
        }
    }


    private void buildRecyclerView() {

        userRecyclerView = findViewById(R.id.userList_recyclerView);
        userRecyclerView.setHasFixedSize(true);

        //разделитель между ViewItem
        //отсюда: https://stackoverflow.com/questions/24618829/how-to-add-dividers-and-spaces-between-items-in-recyclerview
        userRecyclerView.addItemDecoration(new DividerItemDecoration
                (userRecyclerView.getContext(), DividerItemDecoration.VERTICAL)
        );

        userLayoutManager = new LinearLayoutManager(this);
        userlistUserAdapter = new UserlistUserAdapter(userArrayList);

        userRecyclerView.setLayoutManager(userLayoutManager);
        userRecyclerView.setAdapter(userlistUserAdapter);

        //интерфейс для клика с пробросом в ChatActivity
        userlistUserAdapter.setOnUserClickListener(new UserlistUserAdapter.OnUserClickListener() {
            @Override
            public void onUserClick(int position) {
                goToChat(position); //также передаем UserId в выбранном position
            }
        });
    }


    private void goToChat(int position) {
        Intent goToChat = new Intent(UserListActivity.this, ChatActivity.class);

        //получаем данные пользователя при клике и передаем его в интент
        goToChat.putExtra("recipientUserId", userArrayList.get(position).getUserId()); //id пользователя
        goToChat.putExtra("recipientUserName", userArrayList.get(position).getUserName()); //имя пользователя для вставки в тулбар
        goToChat.putExtra("userName", userName); //имя пользователя
        startActivity(goToChat);
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
                Intent goToSignInActivity = new Intent(this, SignInActivity.class);
                startActivity(goToSignInActivity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //звоним с введенным в EditText номером
    public void toPhone(View view) {
        boolean hasCallPhonePermission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED;

        if (hasCallPhonePermission) {
            startActivity(goToPhone());
        }

        else
        {Toast.makeText(this, "Хочешь позвонить? Сначала дай мне доступ к звонкам!", Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_CALL);}

    }

    private Intent goToPhone() {

        final Intent intentToCall = new Intent(Intent.ACTION_CALL);
        String number = callNumber.getText().toString().trim();
        intentToCall.setData(Uri.parse("tel:+7" + number));

        return intentToCall;
    }

}