package com.example.palabraocultaapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var editTextLetra : EditText
    private lateinit var textViewPalabraOculta: TextView
    private lateinit var buttonComprobar : Button
    private val viewModel : PalabraOcultaModel by viewModels()

    private fun iniciarElementos() {
        editTextLetra = findViewById(R.id.editTextLetra)
        textViewPalabraOculta = findViewById(R.id.textViewPalabraOculta)
        buttonComprobar = findViewById(R.id.buttonComprobar)
    }

    private fun initListenerButton() {
        buttonComprobar.setOnClickListener(){ view ->
            if (!viewModel.comprobar(editTextLetra.text.toString().toCharArray().get(0))){
                Toast.makeText(this, "Vaya! Intenta otra letra! Intentos: "+viewModel.intentos+"/5"
                    , Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Acierto!", Toast.LENGTH_SHORT).show()
                var letras = "_ _ _ _ _".toCharArray()
                var letraADesvelar = 0
                for (i in 0..viewModel.letrasAcertadas.size - 1){
                    if (viewModel.letrasAcertadas[i])
                        letras[letraADesvelar] = viewModel.palabra[i]
                    letraADesvelar += 2
                }
                textViewPalabraOculta.text = String(letras)
            }
            if (viewModel.intentos == 5){
                viewModel.nuevoJuego()
                Toast.makeText(this, "Perdiste... Inténtalo otra vez", Toast.LENGTH_SHORT).show()
            } else {
                var ganador = true
                for(acierto in viewModel.letrasAcertadas) {
                    if (!acierto) {
                        ganador = false
                        break
                    }
                }
                if (ganador) {
                    viewModel.nuevoJuego()
                    Toast.makeText(this, "Ganaste! Inténtalo otra vez", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        iniciarElementos()
        initListenerButton()
    }
}