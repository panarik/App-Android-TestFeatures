package com.github.panarik.mobile.app.shop.screen;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;

import com.github.panarik.mobile.app.shop.R;
import com.github.panarik.mobile.app.shop.base.TestBase;
import com.github.panarik.mobile.app.shop.base.espresso.RecyclerViewMatcher;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.anyOf;

public class TestVideoWebBase extends TestBase {


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

        onView(isRoot()).perform(waitFor(2000));

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
                .perform(actionOnItemAtPosition(0, click()));
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
        onView(withId(R.id.freeGame))
                .perform(click());
        onView(withId(R.id.anotherThings))
                .perform(click());
        onView(withId(R.id.toWatchVideo))
                .perform(click());
        onView(withId(R.id.toPlayingAudioActivity))
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
