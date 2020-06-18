package com.github.panarik.mobile.app.shop.screen;

import android.os.SystemClock;
import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.uiautomator.UiDevice;

import com.github.panarik.mobile.app.shop.R;
import com.github.panarik.mobile.app.shop.base.TestBase;

import org.junit.Test;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.assertThat;

public class TestMainBase extends TestBase {


    @Test
    public void editTextNameTest() {
        onView(withId(R.id.editText))
                .perform(typeText("alex"))
                .check(matches(withText("alex")));
    }

    @Test
    public void editTextSpinnerTest() {
        onView(withId(R.id.spinner))
                .perform(click());
        onData(anything())
                .atPosition(0)
                .perform(click())
                .check(matches(withText("Интерьер - 3мм")));
    }

    @Test
    public void viewTextQuantityTest() {
        onView(withId(R.id.textView5))
                .check(matches(withText("0")));
    }

    @Test
    public void viewTextPriceTest() {
        onView(withId(R.id.textView4))
                .check(matches(withText("0.0 $")));
    }

    @Test
    public void editAddToCardTest() {
        //вводим имя
        onView(withId(R.id.editText))
                .perform(typeText("alex"))
                .check(matches(withText("alex")));

        //выбираем товар
        onView(withId(R.id.spinner))
                .perform(click());
        onData(anything())
                .atPosition(0)
                .perform(click())
                .check(matches(withText("Интерьер - 3мм")));

        //закрываем ввод текста
        mDevice.pressBack();

        //указываем количество
        onView(withId(R.id.button2))
               .perform(click());

    }

    @Test
    public void checkPreconditionsTest() {
        assertThat(mDevice, is(notNullValue()));
    }

}
