package com.github.panarik.smartFeatures.screen;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.base.TestBase;

import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.github.panarik.smartFeatures.screen.TestVideoWebBase.waitFor;

public class TestSignInBase extends TestBase {

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



    public static void auth_signIn() {
        //переход в режим signIn
        onView(withId(R.id.chat_toggleSingUpTextView)).perform(click());
        //вводим email
        onView(withId(R.id.chat_emailEditText)).perform(typeText("test2@gmail.com"));
        //вводим пароль
        onView(withId(R.id.chat_passwordEditText)).perform(typeText("123456"));
        //жмем далее
        onView(withId(R.id.chat_loginSignUpButton)).perform(click());
        //ждем
        onView(isRoot()).perform(waitFor(1000));
    }

}
