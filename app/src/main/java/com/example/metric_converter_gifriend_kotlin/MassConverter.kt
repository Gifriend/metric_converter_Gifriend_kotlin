package com.example.metricconverter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.metric_converter_gifriend_kotlin.R

class MassConverterActivity : AppCompatActivity() {

    private lateinit var valueInput: EditText
    private lateinit var unitFromSpinner: Spinner
    private lateinit var unitToSpinner: Spinner
    private lateinit var convertButton: Button
    private lateinit var resultTextView: TextView

    private val units = arrayOf("gram", "kilogram", "ounce")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mass_converter)

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
        val value = valueInput.text.toString().toDoubleOrNull() ?: return
        val unitFrom = unitFromSpinner.selectedItem.toString()
        val unitTo = unitToSpinner.selectedItem.toString()
        var result: Double? = null

        result = when {
            unitFrom == unitTo -> value
            unitFrom == "gram" && unitTo == "kilogram" -> value / 1000
            unitFrom == "kilogram" && unitTo == "gram" -> value * 1000
            unitFrom == "ounce" && unitTo == "gram" -> value * 28.3495
            unitFrom == "gram" && unitTo == "ounce" -> value / 28.3495
            else -> null
        }

        resultTextView.text = "Result: ${result ?: "Invalid conversion"}"
    }
}