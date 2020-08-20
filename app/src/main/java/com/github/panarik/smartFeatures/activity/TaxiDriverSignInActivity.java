package com.github.panarik.smartFeatures.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.panarik.smartFeatures.R;
import com.google.android.material.textfield.TextInputLayout;

public class TaxiDriverSignInActivity extends AppCompatActivity {

    private TextInputLayout taxi_textInputEmail;
    private TextInputLayout taxi_textInputName;
    private TextInputLayout taxi_textInputPass;
    private TextInputLayout taxi_textInputConfirmPass;
    private Button taxi_loginSignUpButton;
    private TextView taxi_toggleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxi_driver_sign_in);

        taxi_textInputEmail = findViewById(R.id.taxi_textInputEmail);
        taxi_textInputName = findViewById(R.id.taxi_textInputName);
        taxi_textInputPass = findViewById(R.id.taxi_textInputPass);
        taxi_textInputConfirmPass = findViewById(R.id.taxi_textInputConfirmPass);
        taxi_loginSignUpButton = findViewById(R.id.taxi_loginSignUpButton);
        taxi_toggleTextView = findViewById(R.id.taxi_toggleTextView);




    }

    //валидация email
    private boolean validateEmail(){
        String emailInput = taxi_textInputEmail
                .getEditText().getText().toString().trim(); //вытаскиваем значение
        //проверка на пустое
        if (emailInput.isEmpty()) {
            taxi_textInputEmail.setError("Please input your email"); //отображаем ошибку
            return false;
        } else {
            taxi_textInputEmail.setError(""); //убираем ошибку
            return true;
        }
    }

    //валидация Name
    private boolean validateName(){
        String nameInput = taxi_textInputName
                .getEditText().getText().toString().trim(); //вытаскиваем значение

        if (nameInput.isEmpty()) {
            taxi_textInputName.setError("Please input your Name"); //отображаем ошибку
            return false;
        } else if (nameInput.length() > 15) {
            taxi_textInputName.setError("Name length have to be less than 15");
            return false;
        } else {
            taxi_textInputName.setError(""); //убираем ошибку
            return true;
        }
    }

    //валидация Password
    private boolean validatePassword(){
        String passwordInput = taxi_textInputPass
                .getEditText().getText().toString().trim(); //вытаскиваем значение password
        String confirmPasswordInput = taxi_textInputConfirmPass
                .getEditText().getText().toString().trim(); //вытаскиваем значение confirm password

        if (passwordInput.isEmpty()) {
            taxi_textInputPass.setError("Please input your Password"); //отображаем ошибку
            return false;
        } else if (passwordInput.length() < 7) {
            taxi_textInputPass.setError("Password length have to be more than 6");
            return false;
        } else if (!passwordInput.equals(confirmPasswordInput)) {
            taxi_textInputPass.setError("Passwords have to match");
            return false;
        } else {
            taxi_textInputPass.setError(""); //убираем ошибку
            return true;
        }
    }



    //проверка корректности заполнения
    public void taxi_loginSignUpUserButton(View view) {
        if (!validateEmail() | !validateName() | !validatePassword()) {
            return;
        }

        String userInput = "Email: "+
                taxi_textInputEmail.getEditText().getText().toString().trim() +
                "\n" + "Name: " +
                taxi_textInputName.getEditText().getText().toString().trim() +
                "\n" + "Password: " +
                taxi_textInputPass.getEditText().getText().toString().trim();

        Toast.makeText(this, userInput, Toast.LENGTH_LONG).show();

    }

    public void taxi_toggleTextView(View view) {
    }
}