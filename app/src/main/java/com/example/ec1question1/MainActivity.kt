package com.example.ec1question1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.ec1question1.Model.Asistente

class MainActivity : AppCompatActivity() {
    //variables of inputs
    lateinit var inputCodigo:EditText
    lateinit var inputNombre:EditText
    lateinit var inputDni:EditText
    lateinit var inputNumeroHoras:EditText
    lateinit var inputTarifaHora:EditText

    //variables of textVies
    lateinit var txtNumeroHoras:TextView
    lateinit var txtSueldoBruto:TextView
    lateinit var txtDesEsSalud:TextView
    lateinit var txtDesAfp:TextView
    lateinit var txtTotalDescuento:TextView
    lateinit var txtSueldoNeto:TextView

    lateinit var  btnCalcular:Button
    lateinit var  btnNuevoCalculo:Button
    lateinit var  btnQuestion2:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputCodigo  = findViewById<EditText>(com.example.ec1question1.R.id.InputCodigo)
        inputNombre = findViewById(R.id.InputNombre)
        inputDni = findViewById(R.id.InputDni)
        inputNumeroHoras = findViewById(R.id.InputNumeroHoras)
        inputTarifaHora = findViewById(R.id.InputTarifaPorHora)

        txtNumeroHoras = findViewById(R.id.txtNumHoras)
        txtSueldoBruto = findViewById(R.id.txtSuedoBruto)
        txtDesAfp = findViewById(R.id.txtAfp)
        txtDesEsSalud = findViewById(R.id.txtEsSalud)
        txtTotalDescuento = findViewById(R.id.txtTotalDescuento)
        txtSueldoNeto = findViewById(R.id.txtSueldoNeto)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnNuevoCalculo = findViewById(R.id.btnNuevaOperacion)
        btnQuestion2 = findViewById(R.id.btnQuestion2)



        btnCalcular.setOnClickListener(){
           calcular()
        }
        btnNuevoCalculo.setOnClickListener(){
            cleanInputs()
        }

        btnQuestion2.setOnClickListener(){
            val intent:Intent = Intent(this,Question2Activity::class.java)
            startActivity(intent)
        }

    }
    fun cleanInputs(){
        inputCodigo.setText("")
        inputDni.setText("")
        inputNombre.setText("")
        inputTarifaHora.setText("")
        inputNumeroHoras.setText("")
    }

    fun calcular(){
        var asistente  =Asistente(inputCodigo.text.toString().toInt() ?: 0,
            inputNombre.text.toString(),
            inputDni.text.toString(),
            inputNumeroHoras.text.toString().toInt() ?: 0 ,
            inputTarifaHora.text.toString().toDouble() ?: 0.0
        );
        var horasExtras = 0
        if(asistente.numeroHoras > 48) horasExtras = asistente.numeroHoras -48
        if(horasExtras == 0) txtNumeroHoras.setText("No tiene horas extras")
        else txtNumeroHoras.setText(horasExtras.toString())
        txtSueldoBruto.setText("S/"+asistente.sueldoBruto().toString())
        txtDesEsSalud.setText("S/"+asistente.descuentoEssalud().toString())
        txtDesAfp.setText("S/"+asistente.descuentoAfp().toString())
        txtTotalDescuento.setText("S/"+asistente.descuentoTotal().toString())
        txtSueldoNeto.setText("S/"+asistente.sueldoNeto().toString())
    }




}