package com.github.panarik.smartFeatures.kaspresso.screen

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import com.github.panarik.smartFeatures.R
import com.github.panarik.smartFeatures.activity.mainMenu.MainActivity
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