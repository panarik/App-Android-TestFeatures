package com.github.panarik.smartFeatures.espresso.base;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.activity.SignInActivity;
import com.google.firebase.auth.FirebaseAuth;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

/*
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
 */

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.web.sugar.Web.onWebView;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

@RunWith(AndroidJUnit4.class)
public class TestBase {

    //текущий девайс
    public UiDevice mDevice;


    //server setup
    // public MockWebServer server = new MockWebServer();
    // public HttpUrl serverUrl;
    // public MockResponse response = new MockResponse();

    //client setup
    // public OkHttpClient client = new OkHttpClient();
    // public String responseBody;

    //start activity
    @Rule
    public ActivityTestRule<SignInActivity> activityActivityTestRule = new ActivityTestRule<SignInActivity>(SignInActivity.class, false, true);

    /*
    @Before
    public void setupMockServer() throws Exception {

        //run server
        server.start();

        //configure server

        serverUrl = server.url("api/test"); //set server path
        server.enqueue(response
                .setBody("test body") //set response body
                .setResponseCode(200) //set response code
        );
    }
     */

    @Before
    public void startMainActivity() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(getInstrumentation());

        //  Press home button?
        // mDevice.pressHome();
    }


    @After
    public void stopMockServer() throws Exception {
        //server.shutdown();

        //logout
        FirebaseAuth.getInstance().signOut();
    }



    /* method with parameters:
       - client - for GET request object
       - serverUrl - for configure server URL of GET request
    */

    /*
    public String getRequest(OkHttpClient client, HttpUrl serverUrl) throws Exception {

        //run client request
        Request request = new Request.Builder()
                .url(serverUrl) //configure server URL of GET request
                .build(); //run request

        //run server response
        try (Response response = client.newCall(request).execute()){
            return response.body().string();
        }
    }
*/

    //UI wait some second
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
