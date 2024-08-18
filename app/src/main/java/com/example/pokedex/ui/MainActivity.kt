package com.example.pokedex.ui

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.R
import com.example.pokedex.data.repository.PokemonRepository
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.network.RetrofitHelper
import com.example.pokedex.viewmodel.PokemonViewModel
import com.example.pokedex.viewmodel.PokemonViewModelFactory
import com.squareup.picasso.Picasso

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: PokemonViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val apiService = RetrofitHelper().getApiService()
        val repository = PokemonRepository(apiService)
        val viewModelFactory = PokemonViewModelFactory(repository)


        viewModel = ViewModelProvider(this, viewModelFactory)[PokemonViewModel::class.java]


        viewModel.pokemonData.observe(this) { pokemon ->
            if (pokemon != null) {
                binding.tvName.text = pokemon.name
                binding.tvId.text = pokemon.id.toString()

                if (pokemon.types.isNotEmpty()) {
                    binding.tvType1.text = pokemon.types[0].type.name
                } else {
                    binding.tvType1.text = ""
                }
                if (pokemon.types.size > 1) {
                    binding.tvType2.text = pokemon.types[1].type.name
                    binding.tvType2.visibility = View.VISIBLE
                } else {
                    binding.tvType2.text = ""
                    binding.tvType2.visibility = View.GONE
                }

                Picasso.get()
                    .load(pokemon.sprites.other.officialartwork.front_default)
                    .into(binding.ivSprite)

            } else {
                binding.tvName.text = getString(R.string.notfound)
            }
        }

        // Inicia a busca pelo Pokémon
        viewModel.fetchPokemon("1")
    }
}