package com.example.palabraocultaapp

import androidx.lifecycle.ViewModel

class PalabraOcultaModel : ViewModel() {
    var nombre : String = ""
        private set

    public fun saludar(saludo : String) : Boolean{
        if (saludo.length < 2 ) {
            return false
        } else {
            nombre = saludo
            return true
        }
    }

}