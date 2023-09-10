package com.example.appimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var txtPeso: TextView
    private lateinit var txtAltura: TextView
    private lateinit var txtResult: TextView
    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        txtPeso = findViewById(R.id.txtPeso)
        txtAltura = findViewById(R.id.txtAltura)
        txtResult = findViewById(R.id.txtResult)
        btnVoltar = findViewById(R.id.btnVoltar)

        val bundle = intent.extras

        if(bundle != null){
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            txtPeso.text = "Peso informado: $peso KG"
            txtAltura.text = "Altura informado: $altura M"

            val imc = peso / (altura * altura)

            val resultado = if(imc < 18.5) {
                Pesos.BAIXO.toString()
            } else if (imc in 18.5 .. 24.9) {
                Pesos.NORMAL.toString()
            } else if (imc in 25.0 .. 29.9) {
                Pesos.SOBREPESO.toString()
            } else {
                Pesos.OBESIDADE.toString()
            }

            txtResult.text = resultado
        }

        btnVoltar.setOnClickListener{
            finish()
        }

    }
}