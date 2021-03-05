package com.github.panarik.smartFeatures.kaspresso.scenario

import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.github.panarik.smartFeatures.data.models.RecyclerViewAdapter
import com.github.panarik.smartFeatures.kaspresso.screen.MainScreen
import com.github.panarik.smartFeatures.kaspresso.screen.SignInScreen
import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

class GoToBlogScenario : Scenario() {

    override val steps: TestContext<Unit>.() -> Unit = {
        step("sign in without auth") {

            MainScreen {
                main_recyclerview.act {
                    RecyclerViewActions.actionOnItem<RecyclerViewAdapter.RecyclerViewViewHolder>(ViewMatchers.hasDescendant(ViewMatchers.withText("RecycleView Kotlin")), ViewActions.click())
                }
            }
        }
    }

}