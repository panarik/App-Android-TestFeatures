package com.github.panarik.smartFeatures.espresso.screen;

import android.content.Intent;
import android.net.Uri;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.espresso.base.IntentsBase;

import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.github.panarik.smartFeatures.espresso.base.TestBase.auth_signIn;
import static com.github.panarik.smartFeatures.espresso.base.TestBase.waitFor;
import static org.hamcrest.core.AllOf.allOf;

public class TestUserList extends IntentsBase {

    private static final String VALID_PHONE_NUMBER = "9096332324";
    private static final Uri INTENT_DATA_PHONE_NUMBER = Uri.parse("tel:+7" + VALID_PHONE_NUMBER);


    @Test

    public void test_typeNumber_ValidInput_InitiatesCall() {
        auth_signIn();
        onView(withId(R.id.recyclerView))
                .perform(actionOnItemAtPosition(7, click()));
        waitFor(1000);

        //ввод номера телефона и закрытие клавиатуры
        onView(withId(R.id.userlist_call_EditText))
                .perform(typeText(VALID_PHONE_NUMBER));
        //нажимаем кнопку, чтобы отправить введенное значение в набор телефонного номера
        onView(withId(R.id.userlist_callToPhone_Button)).perform(click());
        //onView(isRoot()).perform(waitFor(5000));

        // Verify that an intent to the dialer was sent with the correct action, phone
        // number and package. Think of Intents intended API as the equivalent to Mockito's verify.
        intended(allOf(
                hasAction(Intent.ACTION_CALL), //открылась звонилка
                hasData(INTENT_DATA_PHONE_NUMBER))); //в звонилку передалась правильная ссылка
    }


}
