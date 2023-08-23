package com.github.panarik.smartFeatures.activity.freeGame.model

import android.view.View
import com.github.panarik.smartFeatures.R
import com.github.panarik.smartFeatures.activity.freeGame.FreeGameActivity

class FreeGameModel(val activity: FreeGameActivity) {

    fun runGame() {
        activity.hint.visibility = View.GONE
        if ((0..2).random() == 0) chestOpenGold()
        else chestOpenEmpty()
        activity.tryAgain.visibility = View.VISIBLE
    }

    fun startGame() {
        activity.chest.setImageResource(R.drawable.chest_closed)
        activity.tryAgain.visibility = View.GONE
        activity.youVinView.visibility = View.GONE
    }

    private fun chestOpenEmpty() {
        activity.chest.setImageResource(R.drawable.chest_open_empty)
    }

    private fun chestOpenGold() {
        activity.chest.setImageResource(R.drawable.chest_open_gold)
        activity.youVinView.visibility = View.VISIBLE
    }

}