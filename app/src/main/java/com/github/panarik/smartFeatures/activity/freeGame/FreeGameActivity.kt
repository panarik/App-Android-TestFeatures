package com.github.panarik.smartFeatures.activity.freeGame

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.panarik.smartFeatures.R
import com.github.panarik.smartFeatures.activity.freeGame.model.FreeGameModel
import com.github.panarik.smartFeatures.activity.mainMenu.MainActivity

class FreeGameActivity : AppCompatActivity() {
    lateinit var chest: ImageView
    lateinit var tryAgain: Button
    lateinit var youVinView: ImageView
    lateinit var hint: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_free_game)
        initFields()
    }

    fun resetGame(view: View?) {
        FreeGameModel(this).startGame()
    }

    fun runGame(view: View?) {
        FreeGameModel(this).runGame()
    }

    fun goToMainActivity(view: View?) {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun initFields() {
        chest = findViewById(R.id.chest)
        tryAgain = findViewById(R.id.tryAgain)
        youVinView = findViewById(R.id.youVinView)
        hint = findViewById(R.id.freeGame_hintTextView)
    }
}