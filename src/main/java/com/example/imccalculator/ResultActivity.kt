package com.example.imccalculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val imcResult = intent.getDoubleExtra("IMC_RESULT", 0.0)

        val resultTextView = findViewById<TextView>(R.id.result_text)
        val categoryTextView = findViewById<TextView>(R.id.category_text)

        resultTextView.text = String.format("Seu IMC: %.2f", imcResult)

        val category = when {
            imcResult < 18.5 -> "Abaixo do peso"
            imcResult < 24.9 -> "Peso normal"
            imcResult < 29.9 -> "Sobrepeso"
            else -> "Obesidade"
        }
        categoryTextView.text = category
    }
}
