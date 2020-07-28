package com.github.panarik.smartFeatures.screen;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Intent;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;
import android.util.Log;
import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.base.TestBase;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.anyOf;

public class TestVideoWeb extends TestBase {

    Activity currentActivity = null;


    @Test
    public void editSearchMovieTest() {
        goToTestVideoWeb();
        onView(withId(R.id.editNameMovie))
                .perform(typeText("superman"))
                .check(matches(withText("superman")));
    }

    @Test
    public void searchMovieTest() {
        goToTestVideoWeb();
        onView(withId(R.id.editNameMovie))
                .perform(typeText("superman"));
        onView(withId(R.id.searchMovie))
                .perform(click());

        onView(isRoot()).perform(waitFor(1000));

        /*
        onView(allOf(isDisplayed()))
                .check(matches(withText("Superman")));
                //также обрабатываем клик
                //.perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));
         */
         /*
        onView(anyOf(withId(R.id.videoWebView), withId(R.id.titleWebMovieTextView)))
                .check(matches(withText("Superman")));
         */

        onView(withId(R.id.videoWebView))
                .perform(actionOnItemAtPosition(1, click()));
        String itemElementText = getApplicationContext()
                .getResources()
                .getString(R.string.item_element_text);
        onView(withText(itemElementText)).check(matches(isDisplayed()));
        /*
          scrollTo() - Scrolls to the matched View.
          scrollToHolder() - Scrolls to the matched View Holder.
          scrollToPosition() - Scrolls to a specific position.
          actionOnHolderItem() - Performs a View Action on a matched View Holder.
          actionOnItem() - Performs a View Action on a matched View.
         */


    }


    //run to current screen
    public static void goToTestVideoWeb() {


        //переводим форму в режим Sign In
        onView(withId(R.id.chat_toggleSingUpTextView))
                .perform(click());
        //вводим email
        onView(withId(R.id.chat_emailEditText))
                .perform(typeText("test1@gmail.com"));
        //вводим пароль
        onView(withId(R.id.chat_passwordEditText))
                .perform(typeText("123456"));
        //жмем далее
        onView(withId(R.id.chat_loginSignUpButton))
                .perform(click());
    }


    //UI wait some second
    public static ViewAction waitFor(final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "Wait for " + millis + " milliseconds.";
            }

            @Override
            public void perform(UiController uiController, final View view) {
                uiController.loopMainThreadForAtLeast(millis);
            }
        };
    }

}

