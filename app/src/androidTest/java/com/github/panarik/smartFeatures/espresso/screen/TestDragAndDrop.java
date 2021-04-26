package com.github.panarik.smartFeatures.espresso.screen;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.espresso.base.TestBase;

import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class TestDragAndDrop extends TestBase {

    @Test
    public void test_drag_simple() {
        goToDragAndDropActivity();
    }

    private void goToDragAndDropActivity() {
        login_withoutAuth();
        onView(withId(R.id.recyclerView))
                .perform(actionOnItemAtPosition(13, click()));
        onView(isRoot()).perform(waitFor(1000));
    }

}
