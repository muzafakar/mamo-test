package com.mhmdzlfkr.mamotest.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import com.mhmdzlfkr.mamotest.R
import com.mhmdzlfkr.mamotest.databinding.CurrencyWidgetLayoutBinding

class CurrencyWidget @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val inflater = LayoutInflater.from(context)
    private val binding = CurrencyWidgetLayoutBinding.inflate(inflater, this, true)
    private val util = CurrencyUtil()


    private var tempExpression = ""
        set(value) {
            field = value
            evaluateExpression()
        }

    private var expression = ""

    private var amount = ""
        set(value) {
            field = value
            binding.tvAmount.text = field
        }

    private var firstDecimalAmount = ""
        set(value) {
            field = value
            binding.tvDecAmountFirst.text = field
        }

    private var secondDecimalAmount = ""
        set(value) {
            field = value
            binding.tvDecAmountSecond.text = field
        }

    init {
        setupView()
    }

    private fun setupView() {
        fun updateCurrencyTextColor(text: CharSequence?) {
            val amount = text.toString()
            val currencyColor = if (amount.isEmpty()) R.color.grey else R.color.black
            binding.tvCurrency.setTextColor(ContextCompat.getColor(context, currencyColor))
        }

        updateCurrencyTextColor(binding.tvAmount.text.toString())

        binding.apply {
            tvAmount.doOnTextChanged { text, _, _, _ ->
                updateCurrencyTextColor(text)
            }
        }
    }

    fun appendExpression(s: String) {
        // to prevent user from inputting zero-leading
        if ((s == AppConst.DOT || s == "0") && tempExpression.isEmpty()) {
            return
        }

        tempExpression += s
    }

    fun truncateExpression() {
        tempExpression = expression.dropLast(1)
    }

    private fun evaluateExpression() {
        if (tempExpression.contains(AppConst.DOT)) {
            // to preserve decimal format
            val isValid = util.isDecimalStringValid(tempExpression)
            if (!isValid) return

            // to normal and decimal amount
            val amounts = tempExpression.split(AppConst.DOT)
            amount = amounts[0]
            firstDecimalAmount = (amounts[1].getOrNull(0) ?: "").toString()
            secondDecimalAmount = (amounts[1].getOrNull(1) ?: "").toString()

            binding.tvDecSign.text = AppConst.DOT
            expression = tempExpression
        } else {
            binding.tvDecSign.text = ""
            amount = tempExpression
            expression = tempExpression
        }
    }
}