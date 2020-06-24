package com.github.panarik.mobile.app.shop;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.github.panarik.mobile.app.shop.activity.MainActivity;
import com.github.panarik.mobile.app.shop.screen.TestVideoWebBase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.github.panarik.mobile.app.shop.screen.TestVideoWebBase.waitFor;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class RecyclerViewSampleTest {

    //номер view в recycler view
    private static final int itemPosition = 1;

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);


    @Test
    public void recycleView_checkSpecialText_test() {
        TestVideoWebBase.goToTestVideoWeb();
        onView(withId(R.id.editNameMovie))
                .perform(typeText("superman"));
        onView(withId(R.id.searchMovie))
                .perform(click());
        onView(isRoot()).perform(waitFor(1000));


        // First scroll to the position that needs to be matched and click on it.
        onView(ViewMatchers.withId(R.id.videoWebView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(itemPosition, click()));

        // Match the text in an item below the fold and check that it's displayed.
        String itemElementText = getApplicationContext()
                .getResources()
                .getString(R.string.item_element_text);

        onView(withText(itemElementText)).check(matches(isDisplayed()));
    }

}
