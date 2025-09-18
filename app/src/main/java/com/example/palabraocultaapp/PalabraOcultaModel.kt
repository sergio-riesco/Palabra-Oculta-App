package com.example.palabraocultaapp

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class PalabraOcultaModel : ViewModel() {
    private var listaPalabras = arrayOf(
        "canto",
        "luzca",
        "perro",
        "silla",
        "verde",
        "campo",
        "nieve",
        "torre",
        "ríoja",
        "fluir"
    )
    var letrasAcertadas = arrayOf(
        false,
        false,
        false,
        false,
        false
    )
        private set

    var palabra : String = ""
        private set
    var intentos : Int = 0
        private set

    fun comprobar(intento : Char) : Boolean{
        var posicion : Int = 0
        var acierto : Boolean = false
        if (palabra.isBlank())
            escogerPalabra()
        for (letra in palabra) {
            if (letra.lowercase().equals(intento.lowercase())) {
                letrasAcertadas[posicion] = true
                acierto = true
            }
            posicion++
        }
        if (!acierto)
            intentos++
        return acierto
    }

    fun nuevoJuego() {
        intentos = 0
        escogerPalabra()
        letrasAcertadas = arrayOf(false, false, false, false, false)
    }

    private fun escogerPalabra(){
        palabra = listaPalabras[Random.nextInt(0, listaPalabras.size)]
    }
}