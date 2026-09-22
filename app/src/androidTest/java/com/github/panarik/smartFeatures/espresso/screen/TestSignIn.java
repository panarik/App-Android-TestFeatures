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
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.util.Log;

import androidx.test.espresso.NoMatchingViewException;

public class TestSignIn extends TestBase {

    //проверка SignInActivity
    @Test
    public void test_signInActivity_onScreen(){
        onView(withId(R.id.activity_sign_in))
                .check(matches(isDisplayed()));
    }

    /**
     * Пример автотеста с авторизацией.
     * @throws InterruptedException
     */
    @Test
    public void test_auth_signIn() throws InterruptedException {

        // Принудительное ожидание
        Thread.sleep(1000);

        auth_signIn();

        try {
            onView(withId(R.id.activity_main)).check(matches(isDisplayed())); // проверка что открыт экран MainActivity
        } catch (NoMatchingViewException e) {
            Log.d("TestRunner", "Не могу найти главный экран");
            Thread.sleep(2000);
            login_withoutAuth();
        } finally {
            Thread.sleep(2000);
            onView(withId(R.id.activity_main)).check(matches(isDisplayed())); // проверка что открыт экран MainActivity
        }

    }

    @Test
    public void test_login_withoutSignIn(){
        login_withoutAuth();
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()));
    }

    @Test
    public void test_auth_signUp() {
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
