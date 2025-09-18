package com.example.palabraocultaapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
    /*
        private fun initListenerButton() {
            buttonEnviarNombre.setOnClickListener(){ view ->
                if (!viewModel.saludar(editTextNombre.text.toString())){
                    Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                } else {
                    textViewNombre.text = viewModel.nombre
                }
            }

        }
    */
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
        //initListenerButton()
    }
}