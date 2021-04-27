package com.github.panarik.smartFeatures.espresso.screen;

import android.app.Instrumentation;
import android.graphics.Point;
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
import static androidx.test.espresso.matcher.ViewMatchers.withText;
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

        //Instrumentation inst = new Instrumentation();
        //MyViewAction.drag(inst, 550, 550, 550, 1300, 30);

        //onView(isRoot()).perform(drag(400, 400, 400, 400)); //error for RootView
        onView(withId(R.id.dragAndDrop_button))
                .perform(drag(500, 500, 500, 1200)); //при захвате кнопки не двигается. Просто по экрану свайп есть.
        waitFor(3000);
    }



    private void goToDragAndDropActivity() {
        login_withoutAuth();
        onView(withId(R.id.recyclerView))
                .perform(actionOnItemAtPosition(13, click()));
        waitFor(1000);
    }

    private void myDevice_SwipeUp(){
        Point[] coordinates = new Point[2];
        coordinates[0] = new Point(500, 1500); //нижняя точка
        coordinates[1] = new Point(500, 500); //верхняя точка
        mDevice.swipe(coordinates, 10);
    }


    public static ViewAction drag(int startX, int startY, int endX, int endY) {
        return new GeneralSwipeAction(
                Swipe.FAST,
                new CustomisableCoordinatesProvider(startX, startY),
                new CustomisableCoordinatesProvider(endX, endY),
                Press.FINGER);
    }

}
