package com.github.panarik.mobile.app.shop.screen;

import android.view.View;

import androidx.test.espresso.Espresso;

import com.github.panarik.mobile.app.shop.R;
import com.github.panarik.mobile.app.shop.base.TestBase;

import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class TestMainBase extends TestBase {

    @Test
    public void editTextTest(){
        onView(withId(R.id.editText)).perform(typeText("alex")).check(matches(withText("alex")));
        //onView(withId(R.id.addToCart)).perform(click()).check(matches(isDisplayed()));
    }

}
