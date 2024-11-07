package com.example.metricconverter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.metric_converter_gifriend_kotlin.R

class TemperatureConverterActivity : AppCompatActivity() {

    private lateinit var celsiusInput: EditText
    private lateinit var convertButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature_converter)

        celsiusInput = findViewById(R.id.celsiusInput)
        convertButton = findViewById(R.id.convertButton)
        resultTextView = findViewById(R.id.resultTextView)

        convertButton.setOnClickListener { convert() }
    }

    private fun convert() {
        val celsius = celsiusInput.text.toString().toDoubleOrNull() ?: return
        val fahrenheit = (celsius * 9/5) + 32
        resultTextView.text = "Fahrenheit: $fahrenheit"
    }
}