package com.example.pokedex.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.data.model.OfficialArtwork
import com.example.pokedex.data.model.Other
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.PokemonTypeSlot
import com.example.pokedex.data.model.Sprites
import com.example.pokedex.data.model.Type
import com.example.pokedex.databinding.ActivityRecycleBinding
import com.example.pokedex.ui.adapters.PokemonAdapter

class RecycleActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityRecycleBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val sprites =
            Sprites(Other(OfficialArtwork("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/4.png")))
        val type =
            listOf(PokemonTypeSlot(1, Type("water", "")), PokemonTypeSlot(0, Type("fire", "")))

        val pokemonsmock = listOf(
            Pokemon(1, "bulbasaur", sprites, type),
            Pokemon(2, "charmander", sprites, type),
            Pokemon(3, "squirtle", sprites, type)
        )


        val rvLista = binding.rvPoke
        rvLista.adapter = PokemonAdapter(pokemonsmock) {
            detailsOpen(it)
        }
        rvLista.layoutManager = LinearLayoutManager(this)


    }

    private fun detailsOpen(name: String) {
        val details = Intent(this, PokemonDetails::class.java)
        details.putExtra("name", name)
        startActivity(Intent(details))
    }
}