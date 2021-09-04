package com.br.matheus.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.br.matheus.businesscard.App
import com.br.matheus.businesscard.R
import com.br.matheus.businesscard.data.BusinessCard
import com.br.matheus.businesscard.databinding.ActivityAddBusinessCardBinding

class EditBusinessCardActivity : AppCompatActivity() {

    private var businessCard:BusinessCard? = null

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater)}

    private val mainViewModel:MainViewModel by viewModels{
        MainViewModelFactory((application as App).respository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener(){
        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                background = "#"+binding.tilCor.editText?.text.toString().uppercase(),
            )
            mainViewModel.update(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()

            finish()
        }

        binding.btnClose.setOnClickListener{
            finish()
        }


    }
}