package com.github.panarik.smartFeatures.kaspresso.screen

import com.github.panarik.smartFeatures.R
import com.github.panarik.smartFeatures.activity.DragAndDropActivity
import com.kaspersky.kaspresso.screens.KScreen

object DragAndDropScreen : KScreen<DragAndDropScreen>() {

    override val layoutId: Int? = R.layout.activity_drag_and_drop
    override val viewClass: Class<*>? = DragAndDropActivity::class.java

}