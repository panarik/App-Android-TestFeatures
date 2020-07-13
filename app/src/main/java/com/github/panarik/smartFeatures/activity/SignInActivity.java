package com.github.panarik.smartFeatures.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.data.chat.ChatUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.google.firebase.database.FirebaseDatabase.getInstance;

public class SignInActivity extends AppCompatActivity {

    //https://firebase.google.com/docs/auth/android/password-auth?authuser=0
    //создаем объект авторизации
    private FirebaseAuth auth;

    private EditText chat_nameEditText;
    private EditText chat_emailEditText;
    private EditText chat_passwordEditText;
    private EditText chat_passwordConfirmEditText;
    private Button chat_loginSignUpButton;
    private TextView chat_toggleSingUpTextView;

    //переключаем регистрацию и логин
    private boolean chat_loginModeActive;

    //поля для добавления узла users в Firebase
    FirebaseDatabase database;
    DatabaseReference usersDatabaseReference;

    private static final String TAG = "SignInActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        chat_nameEditText = findViewById(R.id.chat_nameEditText);
        chat_emailEditText = findViewById(R.id.chat_emailEditText);
        chat_passwordEditText = findViewById(R.id.chat_passwordEditText);
        chat_passwordConfirmEditText = findViewById(R.id.chat_passwordConfirmEditText);
        chat_loginSignUpButton = findViewById(R.id.chat_loginSignUpButton);
        chat_toggleSingUpTextView = findViewById(R.id.chat_toggleSingUpTextView);

        //инициализируем объект авторизации
        auth = FirebaseAuth.getInstance();
        //инициализируем БД Firebase
        database = getInstance();
        //инициализируем узел в БД "users" для добавления новых пользователей
        usersDatabaseReference = database.getReference().child("users");


        //проверяем зарегистрирован пользователь или нет
        if (auth.getCurrentUser() != null) {
            Intent goToRecyclerViewActivity = new Intent(this, MainActivity.class);
            startActivity(goToRecyclerViewActivity);
        }


        chat_loginSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginSignUpUser(
                        chat_emailEditText.getText().toString().trim(),
                        chat_passwordEditText.getText().toString().trim()
                ); //передаем в метод email и password
            }
        });


    }


    //режимы LogIn or SingUp
    private void loginSignUpUser(String email, String password) { //метод берет email и password

        //проверяем пользователь зарегистрирован или нет
        if (chat_loginModeActive) {

            if //если зарегистрирован и email пустой, то Тост
            (chat_emailEditText.getText().toString().trim().equals("")) {
                Toast.makeText(this, "Введите email", Toast.LENGTH_LONG).show();

            } else if //если зарегистрирован и пароль меньше шести символов, то Тост
            (chat_passwordEditText.getText().toString().trim().length() < 6) {
                Toast.makeText(this, "Пароль должен быть не менее 6 символов", Toast.LENGTH_LONG).show();

            } else { //если зарегистрирован
                //код: https://firebase.google.com/docs/auth/android/password-auth?authuser=0
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = auth.getCurrentUser();
                                    //updateUI(user);
                                    //только когда выполнена авторизация, переходим на главный экран
                                    goToMainActivity();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(SignInActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    //updateUI(null);
                                    // ...
                                }
                                // ...
                            }
                        });
            }

        } else {

            if //если незарегистрирован и email пустой, то Тост
            (chat_emailEditText.getText().toString().trim().equals("")) {
                Toast.makeText(this, "Введите email", Toast.LENGTH_LONG).show();

            } else if //если незарегистрирован и пароль меньше шести символов, то Тост
            (chat_passwordEditText.getText().toString().trim().length() < 6) {
                Toast.makeText(this, "Пароль должен быть не менее 6 символов", Toast.LENGTH_LONG).show();

            } else if //если незарегистрирован и если не введен одинаковый пароль в chat_passwordConfirmEditText, пишем тост
            (!chat_passwordEditText.getText().toString().trim()
                            .equals(chat_passwordConfirmEditText.getText().toString().trim())) {
                Toast.makeText(this, "Введенные пароли не совпадают", Toast.LENGTH_LONG).show();

            } else { //если незарегистрирован, то go to Sign UP
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(
                                this, new OnCompleteListener<AuthResult>() {

                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            // Sign in success, update UI with the signed-in user's information
                                            Log.d(TAG, "createUserWithEmail:success");
                                            FirebaseUser user = auth.getCurrentUser();

                                            //доп метод для создания списка юзеров и использования их в дальнейшем
                                            createUser(user);

                                            //updateUI(user);
                                            //только когда выполнена авторизация, переходим на главный экран
                                            goToMainActivity();


                                        } else {
                                            // If sign in fails, display a message to the user.
                                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                            Toast.makeText(SignInActivity.this, "Authentication failed.",
                                                    Toast.LENGTH_SHORT).show();
                                            //updateUI(null);
                                        }
                                    }

                                }
                        );
            }

        }


    }

    //переход на главный экран с переносом userName
    private void goToMainActivity() {
        Intent goToMainActivity = new Intent(SignInActivity.this, MainActivity.class);
        goToMainActivity.putExtra("userName", chat_nameEditText.getText().toString().trim());
        startActivity(goToMainActivity);
    }


    public void chat_toggleLoginMode(View view) {
        //проверяем
        if (chat_loginModeActive) {
            // go to SIGN UP
            chat_loginModeActive = false;
            chat_loginSignUpButton.setText("Sign Up");
            chat_toggleSingUpTextView.setText("Or log in");
            chat_passwordConfirmEditText.setVisibility(View.VISIBLE);
        } else {
            //go to SING IN
            chat_loginModeActive = true;
            chat_loginSignUpButton.setText("Log In");
            chat_toggleSingUpTextView.setText("Or sign Up");
            chat_passwordConfirmEditText.setVisibility(View.GONE);
        }
    }


    //метод дергается при регистрации нового юзера
    private void createUser(FirebaseUser firebaseUser) {
        ChatUser user = new ChatUser();

        //собираем данные в объект user
        user.setUserId( //используем сеттер из класса ChatUser
                firebaseUser.getUid()); //id извлекаем из Firebase. Метод Firebase извлекающий id юзера из БД Firebase
        user.setUserEmail(
                firebaseUser.getEmail());
        user.setUserName(chat_nameEditText.getText().toString().trim()); //имя берем из формы заполнения и сохраняем в объекте класса ChatUser
        //отправляем на сервер с помощью .push()
        usersDatabaseReference.push().setValue(user);
    }


    public void goToRecyclerViewActivity(View view) {
        Intent goToRecyclerViewActivity = new Intent(this, MainActivity.class);
        startActivity(goToRecyclerViewActivity);
    }
}
