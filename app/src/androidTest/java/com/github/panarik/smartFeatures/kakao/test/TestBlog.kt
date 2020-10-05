package com.github.panarik.smartFeatures.kakao.test

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.github.panarik.smartFeatures.activity.BlogKotlinActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SingleTypeRecyclerTest {
    @Rule
    @JvmField
    val rule = ActivityTestRule(BlogKotlinActivity::class.java)

    @Test
    fun testContentItemsRecyclerView() {


    }
}