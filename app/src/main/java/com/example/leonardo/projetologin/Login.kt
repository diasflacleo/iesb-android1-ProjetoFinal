package com.example.leonardo.projetologin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        supportActionBar?.title = "Login"

        button_cadastrar.setOnClickListener{
            val intent = Intent(this@Login,CadastroUsuario::class.java)
            Toast.makeText(this,"Cadastrar novo usuário.", Toast.LENGTH_LONG)
            startActivity(intent)



        }




    }


}
