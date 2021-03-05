package com.github.panarik.smartFeatures.kaspresso.screen

import android.view.View
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.github.panarik.smartFeatures.R
import com.github.panarik.smartFeatures.activity.MainActivity
import com.kaspersky.kaspresso.screens.KScreen
import org.hamcrest.Matcher

object MainScreen : KScreen<MainScreen>() {

    override val layoutId: Int? = R.layout.activity_main
    override val viewClass: Class<*>? = MainActivity::class.java

    val main_recyclerview = KRecyclerView({ withId(R.id.recyclerView) }, itemTypeBuilder = {
        itemType(MainScreen::MainRecyclerItem)
    })


    class MainRecyclerItem(parent: Matcher<View>) : KRecyclerItem<MainRecyclerItem>(parent) {
        val mainRecycleImage = KImageView { withId(R.id.RecyclerImageView) }
        val mainRecycleTitle = KTextView { withId(R.id.RecyclerTextView1) }
        val mainRecycleDesc = KTextView { withId(R.id.RecyclerTextView2) }
    }
}