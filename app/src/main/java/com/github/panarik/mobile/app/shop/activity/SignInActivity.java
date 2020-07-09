package com.github.panarik.mobile.app.shop.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.panarik.mobile.app.shop.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {

    //https://firebase.google.com/docs/auth/android/password-auth?authuser=0
    //создаем объект авторизации
    private FirebaseAuth auth;

    private EditText chat_nameEditText;
    private EditText chat_emailEditText;
    private EditText chat_passwordEditText;
    private Button chat_loginSignUpButton;
    private TextView chat_toggleSingUpTextView;

    private static final String TAG = "SignInActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        chat_nameEditText = findViewById(R.id.chat_nameEditText);
        chat_emailEditText = findViewById(R.id.chat_emailEditText);
        chat_passwordEditText = findViewById(R.id.chat_passwordEditText);
        chat_loginSignUpButton = findViewById(R.id.chat_loginSignUpButton);
        chat_toggleSingUpTextView = findViewById(R.id.chat_toggleSingUpTextView);

        //инициализируем объект авторизации
        auth = FirebaseAuth.getInstance();

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


    //добавление нового аккаунта
    private void loginSignUpUser(String email, String password) { //метод берет email и password
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        this, new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = auth.getCurrentUser();
                                    //updateUI(user);
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
