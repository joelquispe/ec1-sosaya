package com.example.ec1question1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay

import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class Question3Activity : AppCompatActivity() {
    lateinit var iniciar:Button
    lateinit var adivinar:Button
    lateinit var txtIntentos:TextView
    lateinit var txtCronometro:TextView
    lateinit var inputNumero:EditText
    var h=0
    var s=0
    var m=0
    var intentos =0
    var numero=""
    var cadena="";var horas=""
    var segundos=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question3)

        iniciar = findViewById(R.id.btnStartGame)
        adivinar = findViewById(R.id.btnAdivinar)

        inputNumero = findViewById(R.id.inputNumber)

        txtIntentos = findViewById(R.id.txtIntentos)
        txtCronometro = findViewById(R.id.txtCronometro)

        var gs= GlobalScope.launch {  }

        iniciar.setOnClickListener(){
            inputNumero.isEnabled=true
            adivinar.isEnabled = true
            txtIntentos.isVisible = true
            generarNumero()
            println(numero)
            gs = GlobalScope.launch (Dispatchers.Main){
                while(true) {
                    delay(1000)

                    s = s + 1
                    if (s == 60) {
                        m = m + 1
                        s = 0
                    }
                    if (m==60){
                        h = h + 1
                        m = 0
                    }
                    if (h==24){
                        h=0
                    }
                    horas = "00" + h
                    horas = horas.substring(horas.length - 2, horas.length) + ":"

                    cadena = "00" + m
                    cadena = cadena.substring(cadena.length - 2, cadena.length) + ":"

                    segundos = "00" + s
                    segundos = segundos.substring(segundos.length - 2, segundos.length)
                    cadena = horas + cadena + segundos
                    txtCronometro.setText(cadena)
                }
            }

        }
        adivinar.setOnClickListener(){
            intentos++
            if(numero == inputNumero.text.toString()){
                gs.cancel()
                Toast.makeText(this,"Número adivinado en "+intentos+" intentos", Toast.LENGTH_SHORT).show()
                txtIntentos.setText(intentos.toString())
            }


        }

    }
    fun generarNumero(){
        numero = (Math.random()*10).roundToInt().toString()
    }
}