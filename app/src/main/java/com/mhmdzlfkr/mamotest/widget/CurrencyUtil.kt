package com.mhmdzlfkr.mamotest.widget

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class CurrencyUtil {
    companion object {
        private const val regexPattern = "([0-9]+\\.[0-9]{0,2})+"
        private const val decimalPattern = "###,###,###"
    }

    fun isDecimalStringValid(expression: String): Boolean {
        val dotCount = expression.count { it.toString() == CurrencyWidget.DOT }
        return Regex(regexPattern).matches(expression) && dotCount == 1
    }

    fun formatAmount(amountStr: String): String {
        val amount = amountStr.toDoubleOrNull() ?: return ""
        val formatter = DecimalFormat(decimalPattern, DecimalFormatSymbols.getInstance(Locale.getDefault()))
        return formatter.format(amount)
    }

    fun getDoubleAmount(amountStr: String, decimalAmountStr: String): Double {
        return (amountStr + CurrencyWidget.DOT + decimalAmountStr).toDoubleOrNull() ?: 0.0
    }
}