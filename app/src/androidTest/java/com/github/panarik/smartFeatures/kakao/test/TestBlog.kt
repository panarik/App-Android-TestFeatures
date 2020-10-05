package com.github.panarik.smartFeatures.kakao.test

import android.util.Log
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.github.panarik.smartFeatures.activity.BlogKotlinActivity
import com.github.panarik.smartFeatures.kakao.screen.BlogScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SingleTypeRecyclerTest {
    @Rule
    @JvmField
    val rule = ActivityTestRule(BlogKotlinActivity::class.java)

    @Test
    fun test_recyclerView_withText() {

        onScreen<BlogScreen> {

            recycler {
                isVisible()
                Log.d("test_recyclerView_withText", "before .hasSize")
                hasSize(4)

                firstChild<BlogScreen.MainItem> {
                    isVisible()
                    blog_title {hasText("First title")}
                }

            }

        }

    }
}