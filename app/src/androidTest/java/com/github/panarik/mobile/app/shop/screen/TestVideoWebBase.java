package com.github.panarik.mobile.app.shop.screen;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;

import com.github.panarik.mobile.app.shop.R;
import com.github.panarik.mobile.app.shop.base.TestBase;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class TestVideoWebBase extends TestBase {



    @Test
    public void editSearchMovieTest() {
        goToTestVideoWeb();
        onView(withId(R.id.editNameMovie))
                .perform(typeText("superman"))
                .check(matches(withText("superman")));
    }

    @Test
    public void searchMovieTest(){
        goToTestVideoWeb();
        onView(withId(R.id.editNameMovie))
                .perform(typeText("superman"));
        onView(withId(R.id.searchMovie))
                .perform(click());

        onView(isRoot()).perform(waitFor(5000));

        onView(withId(R.id.videoWebView))
                .check(matches(withText("Superman")));




    }


    public void goToTestVideoWeb() {
        onView(withId(R.id.freeGame))
                .perform(click());
        onView(withId(R.id.anotherThings))
                .perform(click());
        onView(withId(R.id.toWatchVideo))
                .perform(click());
        onView(withId(R.id.toPlayingAudioActivity))
                .perform(click());
    }


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
