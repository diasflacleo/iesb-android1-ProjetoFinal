package com.example.leonardo.projetologin

import android.arch.persistence.room.Room
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.cadastro_usuario.*

class CadastroUsuario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro_usuario)
        supportActionBar?.title = "Cadastro de Usuário"

        val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "room-database"
        ).allowMainThreadQueries().build()


        button_cadastrar_usuario.setOnClickListener {

            //Toast.makeText(this@CadastroProduto,"Salvar Produto",Toast.LENGTH_LONG).show()

            var email : String = ""
            var senha : String = ""
            var senhaConfirmacao : String = ""

            var validacao : Int = 0
            if (editText_email_cadastro.text.toString().trim().length > 0) {
                email = editText_email_cadastro.text.toString()
                validacao = validacao++
            } else {
                Toast.makeText(this@CadastroUsuario, "Usuário sem email.", Toast.LENGTH_LONG).show()
                // editText_nome.error = "Escolha um nome para o produto"

            }
            senha = editText_senha_cadastro.text.toString()
            senhaConfirmacao = editText_confirmacao_cadastro.text.toString()

            if (!senha.equals(senhaConfirmacao)){
                Toast.makeText(this@CadastroUsuario, "Senhas não são iguais.", Toast.LENGTH_LONG).show()
                validacao = validacao++
            }

            val usuario = Usuario(email = email, senha = senha)

            // val produto = Produto(nome = "produto test1", preco = "123", descricao = "test description", imagem = "")

            db.romDao().insertUsuario(usuario)
            Toast.makeText(this@CadastroUsuario, "Usuario cadastrado com sucesso!", Toast.LENGTH_LONG).show()
            val intent = Intent(this@CadastroUsuario,Login::class.java)
            startActivity(intent)

        }



    }

}