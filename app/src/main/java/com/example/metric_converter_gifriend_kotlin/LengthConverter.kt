package com.example.metricconverter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.metric_converter_gifriend_kotlin.R

class LengthConverterActivity : AppCompatActivity() {

    private lateinit var valueInput: EditText
    private lateinit var unitFromSpinner: Spinner
    private lateinit var unitToSpinner: Spinner
    private lateinit var convertButton: Button
    private lateinit var resultTextView: TextView

    private val units = arrayOf("meter", "kilometer", "centimeter")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_length_converter)

        valueInput = findViewById(R.id.valueInput)
        unitFromSpinner = findViewById(R.id.unitFromSpinner)
        unitToSpinner = findViewById(R.id.unitToSpinner)
        convertButton = findViewById(R.id.convertButton)
        resultTextView = findViewById(R.id.resultTextView)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, units)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        unitFromSpinner.adapter = adapter
        unitToSpinner.adapter = adapter

        convertButton.setOnClickListener { convert() }
    }

    private fun convert() {
        val value = valueInput.text.toString().toDoubleOrNull()
        if (value == null) {
            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show()
            return
        }
        val unitFrom = unitFromSpinner.selectedItem.toString()
        val unitTo = unitToSpinner.selectedItem.toString()
        var result = when {
            unitFrom == unitTo -> value
            unitFrom == "meter" && unitTo == "kilometer" -> value / 1000
            unitFrom == "kilometer" && unitTo == "meter" -> value * 1000
            unitFrom == "meter" && unitTo == "centimeter" -> value * 100
            unitFrom == "centimeter" && unitTo == "meter" -> value / 100
            unitFrom == "kilometer" && unitTo == "centimeter" -> value * 100000
            unitFrom == "centimeter" && unitTo == "kilometer" -> value / 100000
            else -> null
        }

        resultTextView.text = "Result: ${result ?: "Invalid conversion"}"
    }
}