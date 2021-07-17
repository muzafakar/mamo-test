package com.mhmdzlfkr.mamotest

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mhmdzlfkr.mamotest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            listenKeyClick(keyboard.btn0)
            listenKeyClick(keyboard.btn1)
            listenKeyClick(keyboard.btn2)
            listenKeyClick(keyboard.btn3)
            listenKeyClick(keyboard.btn4)
            listenKeyClick(keyboard.btn5)
            listenKeyClick(keyboard.btn6)
            listenKeyClick(keyboard.btn7)
            listenKeyClick(keyboard.btn8)
            listenKeyClick(keyboard.btn9)
            listenKeyClick(keyboard.btn0)
            listenKeyClick(keyboard.btnDot)

            keyboard.btnBackspace.apply {
                setOnClickListener { currencyWidget.truncateExpression() }

                setOnLongClickListener {
                    currencyWidget.clearExpression()
                    true
                }
            }
        }

        setContentView(binding.root)
    }

    private fun listenKeyClick(button: Button) {
        button.setOnClickListener {
            val value = button.text.toString()
            binding.currencyWidget.appendExpression(value)
        }
    }
}