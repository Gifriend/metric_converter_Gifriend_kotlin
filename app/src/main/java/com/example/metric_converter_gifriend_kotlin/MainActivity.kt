package com.example.metric_converter_gifriend_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.metric_converter_gifriend_kotlin.ui.theme.Metric_converter_gifriend_kotlinTheme
import com.example.metricconverter.LengthConverterActivity
import com.example.metricconverter.MassConverterActivity
import com.example.metricconverter.TemperatureConverterActivity

class MainActivity : AppCompatActivity() {

    private lateinit var lengthConverterButton: Button
    private lateinit var temperatureConverterButton: Button
    private lateinit var massConverterButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lengthConverterButton = findViewById(R.id.lengthConverterButton)
        temperatureConverterButton = findViewById(R.id.temperatureConverterButton)
        massConverterButton = findViewById(R.id.massConverterButton)

        lengthConverterButton.setOnClickListener {
            val intent = Intent(this, LengthConverterActivity::class.java)
            startActivity(intent)
        }

        temperatureConverterButton.setOnClickListener {
            val intent = Intent(this, TemperatureConverterActivity::class.java)
            startActivity(intent)
        }

        massConverterButton.setOnClickListener {
            val intent = Intent(this, MassConverterActivity::class.java)
            startActivity(intent)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Metric_converter_gifriend_kotlinTheme {
        Greeting("Android")
    }
}