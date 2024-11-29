package com.example.imccalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alturaInput = findViewById<EditText>(R.id.height_input)
        val pesoInput = findViewById<EditText>(R.id.weight_input)
        val calculateButton = findViewById<Button>(R.id.calculate_button)

        calculateButton.setOnClickListener {
            val altura = alturaInput.text.toString().toDoubleOrNull()
            val peso = pesoInput.text.toString().toDoubleOrNull()

            if (altura != null && peso != null) {
                val imc = peso / (altura * altura)
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("IMC_RESULT", imc)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, insira valores validos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
