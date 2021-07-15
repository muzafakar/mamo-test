package com.mhmdzlfkr.mamotest.widget

class CurrencyUtil {
    companion object{
        private const val regexPattern = "([0-9]+\\.[0-9]{0,2})+"
    }

    fun isDecimalStringValid(expression: String) = Regex(regexPattern).matches(expression)
}