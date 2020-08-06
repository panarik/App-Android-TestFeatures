package com.github.panarik.smartFeatures.screen;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.web.webdriver.Locator;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.activity.WebActivity;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.web.assertion.WebViewAssertions.webMatches;
import static androidx.test.espresso.web.sugar.Web.onWebView;
import static androidx.test.espresso.web.webdriver.DriverAtoms.findElement;
import static androidx.test.espresso.web.webdriver.DriverAtoms.getText;
import static androidx.test.espresso.web.webdriver.DriverAtoms.webKeys;
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


    @Test
    public void test_WebView_ID_withText() {
        onWebView()
                .withElement(findElement(Locator.ID,"fsl"))
                .check(webMatches(getText(), containsString("Россия")));
    }

    @Test
    public void test_WebView_XPATH_withText(){
        onWebView()
                .withElement(findElement(Locator.XPATH,"//span[@class='Q8LRLc']"))
                .check(webMatches(getText(), containsString("Россия")));
    }

    @Test
    public void test_WebView_search_withText(){
        onWebView()
                .withElement(findElement(Locator.XPATH, "//input[@class='gLFyf']"))
                .perform(webKeys("abcd"));
    }





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


}
