package com.github.panarik.smartFeatures.espresso.screen;

import android.app.Instrumentation;
import android.os.RemoteException;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.espresso.base.CustomisableCoordinatesProvider;
import com.github.panarik.smartFeatures.espresso.base.MyViewAction;
import com.github.panarik.smartFeatures.espresso.base.TestBase;

import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.github.panarik.smartFeatures.espresso.base.MyViewAction.dragToBottom;

public class TestDragAndDrop extends TestBase {

    @Test
    public void test_ActivityStart() {
        goToDragAndDropActivity();
    }

    @Test
    public void test_dragOnCoordinates() {
        goToDragAndDropActivity();
        waitFor(1000);
        mDevice.drag(550, 550, 550, 1300, 30);
        waitFor(1000);
    }

    @Test
    public void test_myDragDown() {
        goToDragAndDropActivity();
        waitFor(1000);
        //onView(isRoot()).perform(dragToBottom());
        //onView(withId(R.id.dragAndDrop_button)).perform(dragToBottom());
        //waitFor(1000);

        //Instrumentation inst = new Instrumentation();
        //MyViewAction.drag(inst, 550, 550, 550, 1300, 30);

        //onView(withId(R.id.dragAndDrop_button)).perform(drag(400, 400, 400, 400));
        waitFor(3000);
    }



    private void goToDragAndDropActivity() {
        login_withoutAuth();
        onView(withId(R.id.recyclerView))
                .perform(actionOnItemAtPosition(13, click()));
        waitFor(1000);
    }

    private void myDrag(int startX, int startY, int endX, int endY, int speed) {
        mDevice.drag(startX, startY, endX, endY, speed);
    }

    public static ViewAction drag(int startX, int startY, int endX, int endY) {
        return new GeneralSwipeAction(
                Swipe.FAST,
                new CustomisableCoordinatesProvider(startX, startY),
                new CustomisableCoordinatesProvider(endX, endY),
                Press.FINGER);
    }


}
