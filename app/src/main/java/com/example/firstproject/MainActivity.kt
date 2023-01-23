package com.example.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalcular: Button = findViewById<Button>(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(R.id.edittext_peso)
        val edtAltura: EditText = findViewById(R.id.edittext_altura)
        val tvResultado: TextView = findViewById(R.id.txtMsg)

        btnCalcular.setOnClickListener {


            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if(alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {

                val altura: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()

                val alturaFinal: Float = altura * altura
                val result: Float = peso / alturaFinal



                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("Extra_Result", result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Fill in all the Blanks", Toast.LENGTH_LONG).show()
            }

        }

    }
}