package com.example.ec1question1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Question2Activity : AppCompatActivity() {
    lateinit var inputEc1:EditText
    lateinit var inputEc2:EditText
    lateinit var inputEc3:EditText
    lateinit var inputEc4:EditText

    lateinit var btnCalcular:Button
    lateinit var btnCleanInput :Button
    lateinit var btnQuestion3:Button

    lateinit var txtNotaFinal:TextView
    lateinit var txtAprobado :TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question2)

        inputEc1 = findViewById(R.id.inputEc1)
        inputEc2 = findViewById(R.id.inputEc2)
        inputEc3 = findViewById(R.id.inputEc3)
        inputEc4 = findViewById(R.id.inputEc4)

        btnCalcular = findViewById(R.id.btnCalcularEc)
        btnCleanInput = findViewById(R.id.btnCleanInput)
        btnQuestion3 = findViewById(R.id.btnQuestion3)

        txtAprobado = findViewById(R.id.txtAprobado)
        txtNotaFinal = findViewById(R.id.txtNotaFinal)

        btnCalcular.setOnClickListener(){
            mostrarResultado()
        }
        btnCleanInput.setOnClickListener (){
            cleanInputs()
        }
        btnQuestion3.setOnClickListener(){
            val intent:Intent = Intent(this,Question3Activity::class.java)
            startActivity(intent)
        }

    }
    fun calcularPromedio():Double{
        var n1 = inputEc1.text.toString().toInt()
        var n2 = inputEc2.text.toString().toInt()
        var n3 = inputEc3.text.toString().toInt()
        var n4 = inputEc4.text.toString().toInt()

        var promedio = (n1 *0.04) +(n2 * 0.12)+(n3*0.24)+(n4*0.60)
        return promedio.toDouble()
    }
    fun mostrarResultado(){
        var aprobado = "si"
        txtNotaFinal.setText(String.format("%.2f",calcularPromedio()))
        if(calcularPromedio() < 12.5) aprobado = "no"
        if(aprobado == "no"){
            Toast.makeText(this,"Desaprobado",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Aprobado",Toast.LENGTH_SHORT).show()
        }
        txtAprobado.setText(aprobado)
    }
    fun cleanInputs(){
        inputEc1.setText("")
        inputEc2.setText("")
        inputEc3.setText("")
        inputEc4.setText("")
    }
}