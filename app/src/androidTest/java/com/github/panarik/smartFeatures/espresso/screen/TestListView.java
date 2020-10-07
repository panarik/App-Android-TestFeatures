package com.github.panarik.smartFeatures.espresso.screen;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.espresso.base.TestBase;

import org.junit.Test;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;

public class TestListView extends TestBase {

    @Test
    public void test_listItem_withText(){
        goToListViewActivity();
        //отображение ListView
        onView(withId(R.id.listView)).check(matches(isDisplayed()));

        //отображение view item первой строки в ListView
        onData(allOf(is(instanceOf(String.class)), startsWith("Первый")))
                .perform(click());
        onData(allOf(is(instanceOf(String.class)), startsWith("Первый")))
                .check(matches(withText("Первый")));

        //click on view item
        onData(allOf())
                .inAdapterView(withId(R.id.listView))
                .atPosition(2)
                .perform(click());
        onData(allOf(is(instanceOf(String.class)), startsWith("Третий")))
                .check(matches(withText("Третий")));

    }


    private void goToListViewActivity(){
        auth_signIn();
        onView(withId(R.id.recyclerView))
                .perform(actionOnItemAtPosition(3, click()));
        onView(isRoot()).perform(waitFor(1000));
    }

}
