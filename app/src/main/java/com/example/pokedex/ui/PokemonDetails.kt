package com.example.pokedex.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedex.databinding.ActivityPokemonDetailsBinding

class PokemonDetails : AppCompatActivity() {

    val binding by  lazy {
        ActivityPokemonDetailsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val nome = intent.getStringExtra("name")
        binding.tvNameDetails.text = nome.toString()

    }
}