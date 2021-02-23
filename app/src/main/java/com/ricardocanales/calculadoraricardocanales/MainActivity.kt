package com.ricardocanales.calculadoraricardocanales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    var countP1: Int = 0;
    var countP2: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num_1.setOnClickListener { pressDigit("1") }
        num_2.setOnClickListener { pressDigit("2") }
        num_3.setOnClickListener { pressDigit("3") }
        num_4.setOnClickListener { pressDigit("4") }
        num_5.setOnClickListener { pressDigit("5") }
        num_6.setOnClickListener { pressDigit("6") }
        num_7.setOnClickListener { pressDigit("7") }
        num_8.setOnClickListener { pressDigit("8") }
        num_9.setOnClickListener { pressDigit("9") }
        num_0.setOnClickListener { pressDigit("0") }
        sum_btn.setOnClickListener { pressDigit("+") }
        res_btn.setOnClickListener { pressDigit("-") }
        mul_btn.setOnClickListener { pressDigit("*") }
        div_btn.setOnClickListener { pressDigit("/") }
        point_btn.setOnClickListener { pressDigit(".") }
        ac_btn.setOnClickListener {
            screen_textView.text = ""
        }
        c_btn.setOnClickListener {
            screen_textView.text = screen_textView.text.dropLast(1)
        }
        equal_btn.setOnClickListener { result() }
    }

    private fun pressDigit(digit: String) {

        screen_textView.text = "${screen_textView.text}$digit"
        val valueOnScreen = screen_textView.text.toString()
        var ultimateValue = (valueOnScreen[valueOnScreen.length - 1])
        val newValueOnScreen = screen_textView.text.toString()
        val newValue = (newValueOnScreen[newValueOnScreen.length - 1])
        var count1: Int = 0
        var count2: Int = 0
        var count3: Int = 0
        when (ultimateValue) {
            '*' -> count1 += 1
            '+' -> count1 += 1
            '-' -> count1 += 1
            '/' -> count1 += 1
            '.' -> count1 += 1
            '0' -> count1 += 0
            '1' -> count1 += 0
            '2' -> count1 += 0
            '3' -> count1 += 0
            '4' -> count1 += 0
            '5' -> count1 += 0
            '6' -> count1 += 0
            '7' -> count1 += 0
            '8' -> count1 += 0
            '9' -> count1 += 0
        }
        when (newValue) {
            '*' -> count2 += 1
            '+' -> count2 += 1
            '-' -> count2 += 1
            '/' -> count2 += 1
            '.' -> count2 += 1
            '0' -> count2 += 0
            '1' -> count2 += 0
            '2' -> count2 += 0
            '3' -> count2 += 0
            '4' -> count2 += 0
            '5' -> count2 += 0
            '6' -> count2 += 0
            '7' -> count2 += 0
            '8' -> count2 += 0
            '9' -> count2 += 0
        }
        count3 = (count1 + count2)
        if (count3 > 1) {
            screen_textView.text = valueOnScreen.dropLast(1)
            screen_textView.text = "${screen_textView.text}$digit"
            countP1 = count1
            countP2 = count2
        }
        countP1 = count1
        countP2 = count2
    }

    private fun result() {

        if (countP1 > 0) {
            if (countP2 > 0) {
                screen_textView.text = screen_textView.text.dropLast(1)
            }
        }

        if (countP2 > 0) {
            if (countP1 < 1) {
                screen_textView.text = screen_textView.text.dropLast(1)
            }
        }

        try {
            val builder = ExpressionBuilder(screen_textView.text.toString()).build()
            val finalResult = builder.evaluate()
            screen_textView.text = finalResult.toString()
        } catch (e: Exception) {
            screen_textView.text = "ERROR"
        }
    }

}