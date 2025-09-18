package com.example.palabraocultaapp

import androidx.lifecycle.ViewModel

class PalabraOcultaModel : ViewModel() {
    var nombre : String = ""
        private set
    var intentos : Int = 0
        private set

    public fun comprobar(saludo : String) : Boolean{
        if (saludo.length < 2 ) {
            return false
        } else {
            nombre = saludo
            return true
        }
    }

}