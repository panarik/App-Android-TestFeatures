package com.github.panarik.smartFeatures.espresso.screen;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.espresso.base.TestBase;

import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.LayoutAssertions.noEllipsizedText;
import static androidx.test.espresso.assertion.LayoutAssertions.noMultilineButtons;
import static androidx.test.espresso.assertion.LayoutAssertions.noOverlaps;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

public class TextBugUiExample extends TestBase {

    @Test
    public void test_layout_overLaps(){
        goToBugUiExampleActivity();
        onView(withId(R.id.bugUiExample_Text_layout)) .check(noOverlaps());
    }

    @Test
    public void test_layout_EllipsizedText() {
        goToBugUiExampleActivity();
        //onView(allOf(withId(R.id.bugUiExample_layout), hasEllipsizedText()));
        onView(withId(R.id.bugUiExample_Text_layout)).check(noEllipsizedText());
    }

    @Test
    public void test_layout_noMultilineButtons() {
        goToBugUiExampleActivity();
        onView(withId(R.id.bugUiExample_Buttons_layout)).check(noMultilineButtons());
    }


    private void goToBugUiExampleActivity() {
        auth_signIn();
        onView(withId(R.id.recyclerView))
                .perform(actionOnItemAtPosition(11, click()));
    }
}
