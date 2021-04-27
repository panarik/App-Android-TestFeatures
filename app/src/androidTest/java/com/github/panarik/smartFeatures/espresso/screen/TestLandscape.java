package com.github.panarik.smartFeatures.espresso.screen;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.espresso.base.TestBase;

import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class TestLandscape extends TestBase {

    //add one fragment
    @Test
    public void test_addFragment_withText() {
        goToLandscapeActivity();
        onView(withId(R.id.landscape_addButton)).perform(click());
        onView(withId(R.id.landscape_one_fragment_textview)).check(matches(withText("Fragment One")));
    }

    //change fragment
    @Test
    public void test_changeFragment_withText(){
        goToLandscapeActivity();
        onView(withId(R.id.landscape_addButton)).perform(click());
        onView(withId(R.id.landscape_replaceButton)).perform(click());
        onView(withId(R.id.landscape_two_fragment_textview)).check(matches(withText("Fragment Two")));
    }

    //remove fragment
    @Test
    public void test_deleteFragment_withText(){
        goToLandscapeActivity();
        onView(withId(R.id.landscape_addButton)).perform(click());
        onView(withId(R.id.landscape_one_fragment_textview)).check(matches(withText("Fragment One")));

        onView(withId(R.id.landscape_removeButton)).perform(click());
        waitFor(1000);
        onView(withId(R.id.landscape_one_fragment_textview))
                .check(doesNotExist());
    }


    private void goToLandscapeActivity() {
        auth_signIn();
        onView(withId(R.id.recyclerView))
                .perform(actionOnItemAtPosition(8, click()));
        waitFor(1000);
    }
}

