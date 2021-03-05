package com.github.panarik.smartFeatures.kaspresso.tests

import android.Manifest
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.github.panarik.smartFeatures.activity.SignInActivity
import com.github.panarik.smartFeatures.data.blog.BlogViewHolder
import com.github.panarik.smartFeatures.kaspresso.scenario.GoToBlogScenario
import com.github.panarik.smartFeatures.kaspresso.scenario.SignInScenario
import com.github.panarik.smartFeatures.kaspresso.screen.BlogScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class TestBlog : TestCase() {

    @get:Rule
    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    )

    @get:Rule
    val activityTestRule = ActivityTestRule(SignInActivity::class.java, true, false)


    @Test
    fun espressoStyle_Click() {
        run {
            step("Step one") {
                scenario(SignInScenario())
                scenario(GoToBlogScenario())

                BlogScreen {
                    blog_recyclerview.act {
                        RecyclerViewActions.actionOnItem<BlogViewHolder>(ViewMatchers.hasDescendant(ViewMatchers.withText("More titles!")), ViewActions.click())
                    }
                }
            }
        }
    }

    @Test
    fun kakaoStyle_Click() {
        run {
            step("Step one") {
                scenario(SignInScenario())
                scenario(GoToBlogScenario())
                BlogScreen {
                    blog_recyclerview {
                        childWith<BlogScreen.BlogItem> {
                            withDescendant { withText("Third title") }
                        } perform { click() }
                    }
                }
            }
        }
    }

    @Test
    fun kakaoStyle_WithCustomItemTypes_Click() {
        run {
            step("Step one") {
                scenario(SignInScenario())
                scenario(GoToBlogScenario())
                BlogScreen {
                    prefinedItems_blog_recyclerview {
                        firstChild<BlogScreen.TitleItem> { click() } //матчит первый вьюхолдер (просто на существование)
                    }
                }
            }
        }
    }


}