package com.github.panarik.smartFeatures.espresso.screen;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.espresso.base.TestBase;

import org.junit.Test;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class TestVideoWeb extends TestBase {

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

        waitFor(1000);

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

}

