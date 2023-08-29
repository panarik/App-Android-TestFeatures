package com.github.panarik.smartFeatures.activity.tipsCalculator.model

import android.icu.text.NumberFormat
import android.util.Log
import android.widget.Toast
import com.github.panarik.smartFeatures.R
import com.github.panarik.smartFeatures.activity.tipsCalculator.TipsCalcActivity
import com.github.panarik.smartFeatures.databinding.ActivityTipsCalculatorBinding
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.ceil

class TipsCalcModel(
    private val activity: TipsCalcActivity,
    private val binding: ActivityTipsCalculatorBinding
) {

    init {
        binding.tipsCalculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val orderCost = updateOrderCost()
        Log.d("TipsCalculate", "Order cost == $orderCost")
        val tips =
            roundTips(getTipsPercentage(binding.tipsTipOptions.checkedRadioButtonId, orderCost))
        Log.d("TipsCalculate", "Tips == $tips")
        showCurrencyTips(getCurrencyTips(tips))
        Log.d("TipsCalculate", "Currency tips = $tips")
    }

    private fun getTipsPercentage(radioButtonId: Int, orderCost: Double): Double =
        when (radioButtonId) {
            R.id.tips_tip_options_amazing -> orderCost * 0.2
            R.id.tips_tip_options_good -> orderCost * 0.15
            R.id.tips_tip_options_okay -> orderCost * 0.10
            else -> {
                showToast("Unknown Radio Button is checked!")
                0.0
            }
        }

    private fun roundTips(internalTips: Double): Double =
        if (binding.tipsRoundUpTipSwitch.isChecked) ceil(internalTips)
        else {
            val result = BigDecimal(internalTips).setScale(2, RoundingMode.UP).toDouble()
            result
        }

    private fun getCurrencyTips(tips: Double): String =
        NumberFormat.getCurrencyInstance().format(tips)

    private fun updateOrderCost(): Double {
        val input = binding.tipsCostOfService.editText?.text.toString()
        return if (input.isEmpty()) 0.0 else input.toDouble()
    }

    private fun showToast(text: String) {
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
    }

    private fun showCurrencyTips(tips: String) {
        binding.tipsResult.text = tips
    }

}