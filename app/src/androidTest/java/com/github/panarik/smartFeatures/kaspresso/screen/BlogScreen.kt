package com.github.panarik.smartFeatures.kaspresso.screen

import androidx.test.espresso.matcher.ViewMatchers.withId
import com.agoda.kakao.recycler.KRecyclerView
import com.github.panarik.smartFeatures.R
import com.github.panarik.smartFeatures.activity.BlogKotlinActivity
import com.kaspersky.kaspresso.screens.KScreen

import android.view.View
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.text.KTextView
import org.hamcrest.Matcher
import com.agoda.kakao.common.builders.ViewBuilder

object BlogScreen : KScreen<BlogScreen>() {

    override val layoutId: Int? = R.layout.activity_blog_kotlin
    override val viewClass: Class<*>? = BlogKotlinActivity::class.java

    val blog_recyclerview = KRecyclerView({ withId(R.id.blog_recyclerview) }, itemTypeBuilder = {
        itemType(::BlogItem)
    })


    class BlogItem(parent: Matcher<View>) : KRecyclerItem<BlogItem>(parent) {
        val blogImage = KImageView { withId(R.id.blog_image) }
        val blogTitle = KTextView { withId(R.id.blog_title) }
    }


}