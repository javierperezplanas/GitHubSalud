package com.example.salud

data class User(val id: Int, val nombre: String, val correo: String, val edad: Int,val peso: Double, val altura: Double){

fun calculaIMC(peso: Double, altura: Double): Double {
    val imc = (peso/(altura*altura/1000))
    return imc
}

}