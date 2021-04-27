package com.github.panarik.smartFeatures.espresso.screen;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.espresso.base.TestBase;

import org.junit.Test;

import java.util.Random;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class TestSignIn extends TestBase {

    //проверка SignInActivity
    @Test
    public void test_signInActivity_onScreen(){
        onView(withId(R.id.activity_sign_in))
                .check(matches(isDisplayed()));
    }

    //Sign In
    @Test
    public void test_auth_signIn(){
        auth_signIn();
        //находимся в MainActivity
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()));
    }

    @Test
    public void test_login_withoutSignIn(){
        login_withoutAuth();
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()));
    }

    @Test
    public void test_auth_signUp(){
        //вводим новый email
        final Random random = new Random();
        onView(withId(R.id.chat_emailEditText)).perform(typeText
                ("test"+random.nextInt(9000)+"@gmail.com"));


        //вводим пароль
        onView(withId(R.id.chat_passwordEditText)).perform(typeText("123456"));
        //вводим подтверждение пароля
        onView(withId(R.id.chat_passwordConfirmEditText)).perform(typeText("123456"));
        //жмем кнопку Далее
        onView(withId(R.id.chat_loginSignUpButton)).perform(click());
        //ждем
        waitFor(1000);
        //переход на MainActivity
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()));
    }

}
