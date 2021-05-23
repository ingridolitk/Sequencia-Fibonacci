package com.ingrid.seq_fibonacci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.io.print as print1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTitle("Sequência de Fibonacci")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sequencia = findViewById<EditText>(R.id.seqFibonac)
        val btn = findViewById<Button>(R.id.btnFib)
        val resultado = findViewById<TextView>(R.id.resultado)
        btn.setOnClickListener {
            val fibonacciSeq = mutableListOf<Int>()
            fibonacciSeq.clear()
            var i = 0
            var t1 = 0
            var t2 = 1
            var recSeq = sequencia?.text.toString()

            if (recSeq.isEmpty()) {
                 sequencia.error = "Informe a sequência de fibonacci"
                Toast.makeText(
                    this,
                    "Por favor informe a sequência de fibonacci.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                resultado.visibility = View.VISIBLE

                for (i in 0..recSeq.toInt()-1) {
                    if (i == 0) {
                        fibonacciSeq.add(1)
                    } else {
                        recSeq = (t1 + t2).toString()
                        fibonacciSeq.add(recSeq.toInt())
                        t1 = t2
                        t2 = recSeq.toInt()
                    }
                }
                resultado.text = fibonacciSeq.toString()
            }
        }
    }
}


