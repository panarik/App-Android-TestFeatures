package com.github.panarik.smartFeatures.kakao.screen


import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.github.panarik.smartFeatures.R
import org.hamcrest.Matcher


class BlogScreen : Screen<BlogScreen>() {

    val recycler: KRecyclerView = KRecyclerView(
            { withId(R.id.blog_recyclerview) },
            itemTypeBuilder =
            {
                itemType(::MainItem)
            }
    )

    class MainItem(parent: Matcher<View>) : KRecyclerItem<MainItem>(parent) {
        val blog_title: KTextView = KTextView(parent) { withId(R.id.blog_title) }
    }

}
