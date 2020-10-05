package com.github.panarik.smartFeatures.kakao.test

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.github.panarik.smartFeatures.activity.SignInActivity
import com.github.panarik.smartFeatures.kakao.screen.SignInScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class TestSignIn {

    @Rule
    @JvmField
    val rule = ActivityTestRule(SignInActivity::class.java)

    @Test
    fun testContentScreen() {

        onScreen<SignInScreen>{

            signIn {
                isVisible()
                click()
            }

            email {
                isVisible()
                typeText("test2@gmail.com")
            }

            pass {
                isVisible()
                typeText("123456")
            }

            loginSignUpButton {
                isVisible()
                click()
            }

        }



    }
}