package com.github.panarik.smartFeatures.kaspresso.tests

import android.Manifest
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.github.panarik.smartFeatures.activity.SignInActivity
import com.github.panarik.smartFeatures.kaspresso.scenario.SignInScenario
import com.github.panarik.smartFeatures.kaspresso.screen.SignInScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class TestSignIn : TestCase() {

    @get:Rule
    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    )

    @get:Rule
    val activityTestRule = ActivityTestRule(SignInActivity::class.java, true, false)


    @Test
    fun test_SignInWithoutAuth() {
        run {
            step("test signIn") {
                scenario(
                        SignInScenario()
                )

            }
        }
    }


}