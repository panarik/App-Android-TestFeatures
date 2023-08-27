package com.github.panarik.smartFeatures.activity.mainMenu.model

import com.github.panarik.smartFeatures.R
import com.github.panarik.smartFeatures.activity.BlogKotlinActivity
import com.github.panarik.smartFeatures.activity.BugUiExampleActivity
import com.github.panarik.smartFeatures.activity.DragAndDropActivity
import com.github.panarik.smartFeatures.activity.freeGame.FreeGameActivity
import com.github.panarik.smartFeatures.activity.LandscapeActivity
import com.github.panarik.smartFeatures.activity.ListViewActivity
import com.github.panarik.smartFeatures.activity.PictureEffectsActivity
import com.github.panarik.smartFeatures.activity.PlayingAudioActivity
import com.github.panarik.smartFeatures.activity.ShopMainActivity
import com.github.panarik.smartFeatures.activity.TaxiSplashScreenActivity
import com.github.panarik.smartFeatures.activity.UserListActivity
import com.github.panarik.smartFeatures.activity.VideoLocalActivity
import com.github.panarik.smartFeatures.activity.VideoWebActivity
import com.github.panarik.smartFeatures.activity.WebActivity
import com.github.panarik.smartFeatures.activity.tipsCalculator.TipsCalcActivity

object MenuHolder {

    @OptIn(ExperimentalStdlibApi::class)
    val menu = buildList {
        add(
            MenuItem(
                RecyclerViewItem(
                    "Mobile shopping",
                    "Insert text, spinner, quantity, sopping card, send order on email",
                    R.drawable.mobile_shop_shoping
                ), ShopMainActivity()
            )
        )
        add(
            MenuItem(
                RecyclerViewItem(
                    "Free Game",
                    "эффекты alpha и немного математики",
                    R.drawable.chest_open_gold
                ),
                FreeGameActivity()
            )
        )
        add(
            MenuItem(
                RecyclerViewItem(
                    "Picture effects",
                    "alpha, rotate, scale, slide effects",
                    R.drawable.picture_effects_plash_smoke
                ), PictureEffectsActivity()
            )
        )
        add(
            MenuItem(
                RecyclerViewItem(
                    "List View",
                    "пример простого списка значений",
                    R.drawable.list_view_list
                ), ListViewActivity()
            )
        )
        add(
            MenuItem(
                RecyclerViewItem(
                    "Play music",
                    "sound playing, play pause buttons, seekBar",
                    R.drawable.playing_audio_band
                ), PlayingAudioActivity()
            )
        )
        add(
            MenuItem(
                RecyclerViewItem(
                    "Local video",
                    "video from APK, control panel, volume listener",
                    R.drawable.video_local_video
                ), VideoLocalActivity()
            )
        )
        add(
            MenuItem(
                RecyclerViewItem(
                    "Movies online",
                    "Text and pictures from API, RecycleView, search function",
                    R.drawable.video_web_movie
                ), VideoWebActivity()
            )
        )
        add(
            MenuItem(
                RecyclerViewItem(
                    "Messenger",
                    "Firebase objects, GET Firebase realtime database data, POST messages into Firebase",
                    R.drawable.chat_chatlogo
                ), UserListActivity()
            )
        )
        add(
            MenuItem(
                RecyclerViewItem(
                    "Landscape Orientation",
                    "Simple Fragments, orientation screen",
                    R.drawable.landscape_logo
                ), LandscapeActivity()
            )
        )
        add(
            MenuItem(
                RecyclerViewItem(
                    "Go To WEB!",
                    "WebView, perform system Back button",
                    R.drawable.web_logo
                ), WebActivity()
            )
        )
        add(
            MenuItem(
                RecyclerViewItem(
                    "You need Taxi!",
                    "Mapping, GEO",
                    R.drawable.taxi_logo
                ), TaxiSplashScreenActivity()
            )
        )
        add(
            MenuItem(
                RecyclerViewItem(
                    "UI bugs",
                    "UI bug in View",
                    R.drawable.bug_ui_example_logo
                ), BugUiExampleActivity()
            )
        )
        add(
            MenuItem(
                RecyclerViewItem(
                    "RecycleView Kotlin",
                    "Simple functional for benchmark testing",
                    R.drawable.recycle_logo_500x500
                ), BlogKotlinActivity()
            )
        )
        add(
            MenuItem(
                RecyclerViewItem(
                    "Drag and drop",
                    "Simple drag and drop functional for UI tests",
                    R.drawable.dragndrop
                ), DragAndDropActivity()
            )
        )
        add(
            MenuItem(
                RecyclerViewItem(
                    "Tips Calculator",
                    "Use View binding calculator",
                    R.drawable.tips
                ), TipsCalcActivity()
            )
        )
    }

    fun getRecyclerViewItems(): List<RecyclerViewItem> =
        menu.map { it.menuItem }

}