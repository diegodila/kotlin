package com.example.testapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.testapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    //TODO 04: LINK COM BOTOES DA TELA
    //TODO 05: ADCIONARA LISTENER A CADA UM DOS BOTOES
    //TODO 06: SUBIR TOASTER COM NOME DO BOTOES AO SEREM CLICADOS

    private lateinit var binding: ActivityMain2Binding
//    private lateinit var btnpedra: Button
//    private lateinit var btnpapel: Button
//    private lateinit var btntesoura: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)
//        setContentView(R.layout.activity_main2)
        binding.playerChooseValue = getString(R.string.zero)

        setupListeners()
//        setupView()


    }

//    private fun setupView() {
//        btnpedra = findViewById(R.id.button0)
//        btnpapel = findViewById(R.id.button1)
//        btntesoura = findViewById(R.id.button2)
//        setupListeners()
//
//    }

    private fun setupListeners() {
//        binding.button0.setOnClickListener {
//            Toast.makeText(this,getString(R.string.autonomia),Toast.LENGTH_SHORT).show()
//        }
//        binding.button1.setOnClickListener {
//            Toast.makeText(this,getString(R.string.abacate),Toast.LENGTH_SHORT).show()
//        }
//        binding.button2.setOnClickListener {
//            Toast.makeText(this,getString(R.string.distancia),Toast.LENGTH_SHORT).show()
//        }
        //------------------------------------------------------------------------
//        binding.button0.setOnClickListener {
//            binding.diegoid.text = binding.button0.text
//        }
//        binding.button1.setOnClickListener {
//            binding.diegoid.text = binding.button1.text
//        }
//        binding.button2.setOnClickListener {
//            binding.diegoid.text = binding.button2.text
//        }
        //------------------------------------------------------------------------
        binding.button0.setOnClickListener {
            binding.playerChooseValue = binding.button0.text.toString()
        }
        binding.button1.setOnClickListener {
            binding.playerChooseValue = binding.button1.text.toString()
        }
        binding.button2.setOnClickListener {
            binding.playerChooseValue = binding.button2.text.toString()
        }
    }


}


