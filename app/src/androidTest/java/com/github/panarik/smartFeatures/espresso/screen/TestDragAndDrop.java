package com.github.panarik.smartFeatures.espresso.screen;

import android.util.Log;

import androidx.test.uiautomator.UiDevice;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.espresso.base.TestBase;

import org.junit.Test;

import java.io.File;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class TestDragAndDrop extends TestBase {

    @Test
    public void test_ActivityStart() {
        goToDragAndDropActivity();
    }

    @Test
    public void test_clickOnCoordinates(){
        goToDragAndDropActivity();
        waitFor(1000);

       mDevice.drag(675, 900, 675, 1780, 20);
        waitFor(2000);
//
//        mDevice.swipe(100, 100, 100,400,20);
//        waitFor(2000);
//
//        //клик
//        mDevice.click(50,50);
//        Log.d("espresso", "click (50, 50)");
//        waitFor(2000);
//
//        File file = new File("/sdcard0/filename.png");
//        mDevice.takeScreenshot(file);
//        Log.d("espresso", "takeScreenshot(/sdcard0/DCIM/Screenshots/)");
//        waitFor(2000);

        mDevice.pressHome();
        waitFor(2000);
    }


    private void goToDragAndDropActivity() {
        login_withoutAuth();
        onView(withId(R.id.recyclerView))
                .perform(actionOnItemAtPosition(13, click()));
        onView(isRoot()).perform(waitFor(1000));
    }

}
