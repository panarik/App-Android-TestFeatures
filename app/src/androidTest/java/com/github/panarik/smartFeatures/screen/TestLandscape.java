package com.github.panarik.smartFeatures.screen;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.base.TestBase;

import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.github.panarik.smartFeatures.screen.TestSignIn.auth_signIn;
import static com.github.panarik.smartFeatures.screen.TestVideoWeb.waitFor;

public class TestLandscape extends TestBase {

    //add one fragment
    @Test
    public void test_addFragment_withText() {
        goToLandscapeActivity();
        onView(withId(R.id.landscape_addButton))
                .perform(click());
        onView(withId(R.id.landscape_one_fragment_textview))
                .check(matches(withText("Fragment One")));
    }

    //change fragment
    @Test
    public void test_changeFragment_withText(){
        goToLandscapeActivity();
        onView(withId(R.id.landscape_addButton)).perform(click());
        onView(withId(R.id.landscape_replaceButton)).perform(click());
        onView(withId(R.id.landscape_two_fragment_textview)).check(matches(withText("Fragment Two")));
    }


    private void goToLandscapeActivity() {
        auth_signIn();
        onView(withId(R.id.recyclerView))
                .perform(actionOnItemAtPosition(8, click()));
        onView(isRoot()).perform(waitFor(1000));
    }
}

