package com.github.panarik.smartFeatures.base;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.GrantPermissionRule;

import com.github.panarik.smartFeatures.activity.SignInActivity;
import com.google.firebase.auth.FirebaseAuth;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class IntentsBase {

    //доступ к звонкам
    @Rule
    public GrantPermissionRule grantPermissionRule = GrantPermissionRule.grant("android.permission.CALL_PHONE");

    //start test activity
    @Rule
    public IntentsTestRule<SignInActivity> mActivityRule = new IntentsTestRule<>(SignInActivity.class);

    //мокаем сторонние интенты. Возвращаем NULL.
    @Before
    public void stubAllExternalIntents() {
        // By default Espresso Intents does not stub any Intents. Stubbing needs to be setup before every test run.
        // In this case all external Intents will be blocked.
        intending(not(isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));
    }


    @After
    public void stopMockServer() throws Exception {
        //server.shutdown();

        //logout
        FirebaseAuth.getInstance().signOut();
    }

}
