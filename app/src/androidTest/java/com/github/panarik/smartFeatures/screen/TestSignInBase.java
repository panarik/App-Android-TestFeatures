package com.github.panarik.smartFeatures.screen;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.base.TestBase;

import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class TestSignInBase extends TestBase {

    //проверка SignInActivity
    @Test
    public void test_signInActivity_onScreen(){
        onView(withId(R.id.activity_sign_in))
                .check(matches(isDisplayed()));
    }

}
