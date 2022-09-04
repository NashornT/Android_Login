package com.example.alura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.example.alura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setup()

    }

    private fun setup() {
        setupClick()
    }


    private  fun setupClick(){
        binding.button.setOnClickListener{
            abreLogado()
        }

        binding.buttonCadastro.setOnClickListener {
            abreCadastro()
        }

        binding.buttonEsque.setOnClickListener {
            abreEsqueci()
        }
    }

    private fun validSenha() {
        binding.TextinputSenha.doAfterTextChanged {
            if (isvalidSenha()){
                Toast.makeText( this, "Senha valida",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText( this,"Senha invalida", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isvalidSenha(): Boolean{
        val senha = binding.TextinputSenha.text.toString()

        return senha.length > 5
    }

    private fun validEmail() {
        binding.TextinputEmail.doAfterTextChanged {
            if (isvalidEmail()){
                Toast.makeText(this,"Email valido",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Email invalido",Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun isvalidEmail(): Boolean {
        val email = binding.TextinputEmail.text.toString()
        if (TextUtils.isEmpty(email)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }



    private fun abreEsqueci() {
        startActivity(Intent(this,Esqueci_senha::class.java))
    }

    private fun abreCadastro() {
        startActivity(Intent(this,Cadastro::class.java))
    }

    private fun abreLogado() {
        if (isvalidSenha() && isvalidEmail()){
            startActivity(Intent(this,Logado::class.java))
        }
    }
}