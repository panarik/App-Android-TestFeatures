package com.github.panarik.smartFeatures.kaspresso.scenario

import androidx.test.rule.ActivityTestRule
import com.github.panarik.smartFeatures.activity.SignInActivity
import com.github.panarik.smartFeatures.kaspresso.screen.SignInScreen
import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.junit.Rule

class SignInScenario : Scenario() {

    @get:Rule
    val activityTestRule = ActivityTestRule(SignInActivity::class.java, true, false)




    override val steps: TestContext<Unit>.() -> Unit = {
        step("sign in without auth") {
            activityTestRule.launchActivity(null)
            SignInScreen {
                signIn_withoutAuth {
                    click()
                }
            }
        }
    }

}
