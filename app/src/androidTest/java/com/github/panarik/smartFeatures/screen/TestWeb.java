package com.github.panarik.smartFeatures.screen;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.web.webdriver.Locator;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.activity.SignInActivity;
import com.github.panarik.smartFeatures.activity.WebActivity;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.web.assertion.WebViewAssertions.webMatches;
import static androidx.test.espresso.web.sugar.Web.onWebView;
import static androidx.test.espresso.web.webdriver.DriverAtoms.findElement;
import static androidx.test.espresso.web.webdriver.DriverAtoms.getText;
import static org.hamcrest.Matchers.containsString;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TestWeb {

    @Rule
    public ActivityTestRule<WebActivity> activityActivityTestRule = new ActivityTestRule<WebActivity>(WebActivity.class, false, true) {
        @Override
        protected void afterActivityLaunched() {
            onWebView(withId(R.id.web_webView)).forceJavascriptEnabled();
        }
    };

    private static final String text = "Россия";


    @Test
    public void test_WebView_classQ8LRLc_ID_withText() {
        onWebView()
                .withElement(findElement(Locator.ID,"fsl"))
                .check(webMatches(getText(), containsString("Россия")));
    }

    @Test
    public void test_WebView_classQ8LRLc_XPATH_withText(){

        onWebView()
                .withElement(findElement(Locator.XPATH,"//span[@class='Q8LRLc']"))
                .check(webMatches(getText(), containsString("Россия")));
    }


    private void goToWeb() {
        auth_signIn();
        onView(withId(R.id.recyclerView))
                .perform(actionOnItemAtPosition(9, click()));
        onView(isRoot()).perform(waitFor(1000));
    }


    //флоу signIn
    public static ViewAction waitFor(final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "Wait for " + millis + " milliseconds.";
            }

            @Override
            public void perform(UiController uiController, final View view) {
                uiController.loopMainThreadForAtLeast(millis);
            }
        };
    }


    //флоу signIn
    public static void auth_signIn() {
        //переход в режим signIn
        onView(withId(R.id.chat_toggleSingUpTextView)).perform(click());
        //вводим email
        onView(withId(R.id.chat_emailEditText)).perform(typeText("test2@gmail.com"));
        //вводим пароль
        onView(withId(R.id.chat_passwordEditText)).perform(typeText("123456"));
        //жмем далее
        onView(withId(R.id.chat_loginSignUpButton)).perform(click());
        //ждем
        onView(isRoot()).perform(waitFor(3000));
    }

}
