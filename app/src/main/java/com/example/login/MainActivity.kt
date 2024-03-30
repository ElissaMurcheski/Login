package com.example.login

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val usuarioAdmin = "elissa"
    val senhaAdmin = "admin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun entrar(view: View) {
        val usuario = findViewById<EditText>(R.id.editTextUsuario).text.toString()
        val senha = findViewById<EditText>(R.id.editTextSenha).text.toString()

        if (usuario == usuarioAdmin && senha == senhaAdmin) {
            Toast.makeText(this, "Bem-vinda Elissa", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Usuário e/ou senha inválido", Toast.LENGTH_LONG).show()
        }
    }
}