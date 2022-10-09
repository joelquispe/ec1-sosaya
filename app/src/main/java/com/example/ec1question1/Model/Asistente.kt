package com.example.ec1question1.Model

class Asistente {
    var codigo:Int = 0;
    var nombre:String="";
    var dni :String=""
    var numeroHoras:Int=0;
    var tarifaHora:Double =0.0;

    constructor(codigo:Int,nombre:String,dni:String,numeroHoras:Int,tarifaHora:Double){
        this.codigo = codigo;
        this.nombre = nombre;
        this.dni = dni;
        this.numeroHoras = numeroHoras;
        this.tarifaHora = tarifaHora;
    }

   fun sueldoBruto(): Double {
        var horasExtras = 0
        if(numeroHoras > 48)  horasExtras = numeroHoras-48
        return (numeroHoras * tarifaHora) + (horasExtras * (tarifaHora*2))
    }


    fun descuentoEssalud():Double{
        return this.sueldoBruto()*0.12
    }

    fun descuentoAfp():Double{
        return this.sueldoBruto()*0.11
    }

   fun descuentoTotal():Double{
        return this.descuentoAfp() + this.descuentoEssalud()
    }
    fun sueldoNeto():Double{
        return this.sueldoBruto()- this.descuentoTotal()
    }
}