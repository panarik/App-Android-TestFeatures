package com.github.panarik.smartFeatures.kaspresso.scenario

import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.github.panarik.smartFeatures.activity.mainMenu.model.RecyclerViewAdapter
import com.github.panarik.smartFeatures.kaspresso.screen.MainScreen
import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

class GoToDragScenario : Scenario()  {

    override val steps: TestContext<Unit>.() -> Unit = {
        step("go to DragAndDrop Activity") {

            MainScreen {
                main_recyclerview.act {
                    RecyclerViewActions.actionOnItem<RecyclerViewAdapter.RecyclerViewViewHolder>(ViewMatchers.hasDescendant(ViewMatchers.withText("Drag and drop")), ViewActions.click())
                }
            }
        }
    }
}