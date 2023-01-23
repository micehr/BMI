package com.example.firstproject

import android.app.DirectAction
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CancellationSignal
import android.view.MenuItem
import android.widget.TextView
import java.util.function.Consumer

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassification = findViewById<TextView>(R.id.textview_classification)
        val result = intent.getFloatExtra("Extra_Result", 0.1f)

        tvResult.text = result.toString()

        val classification = if (result < 18.5) {
            "Underweight"
        } else if (result in 18.5f..24.9f) {
            "NORMAL"
        } else if (result in 25f..29.9f) {
            "Overweight"
        } else if (result in 30f..39.9f) {
            "Obese"
        } else {
            "Very Obese"
        }

        tvClassification.text = getString(R.string.message_classification, classification)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

}