package com.github.panarik.smartFeatures.activity.tipsCalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.panarik.smartFeatures.databinding.ActivityTipsCalculatorBinding

class TipsCalcActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTipsCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}