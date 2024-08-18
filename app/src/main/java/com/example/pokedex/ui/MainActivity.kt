package com.example.pokedex.ui

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.R
import com.example.pokedex.data.repository.PokemonRepository
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.network.RetrofitHelper
import com.example.pokedex.utils.Utils
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
                val nome = Utils.formatarPrimeiraLetraMaiuscula(pokemon.name)
                binding.tvName.text = nome

                val id = Utils.formatarNumero(pokemon.id)
                binding.tvId.text = id

                if (pokemon.types.isNotEmpty()) {
                    val tipo = pokemon.types[0].type.name
                    binding.tvType1.text = tipo
                    val corFundo = Utils.TIPO_COLOR_FUNDO[tipo] ?: Color.WHITE
                    val corLetra = Utils.TIPO_COLOR_FONTE[tipo] ?: Color.WHITE

                    binding.tvType1.setBackgroundColor(corFundo)
                    binding.tvType1.setTextColor(corLetra)
                } else {
                    binding.tvType1.text = ""
                }
                if (pokemon.types.size > 1) {
                    binding.tvType2.visibility = View.VISIBLE
                    val tipo = pokemon.types[1].type.name
                    binding.tvType2.text = tipo
                    val corFundo = Utils.TIPO_COLOR_FUNDO[tipo] ?: Color.WHITE
                    val corLetra = Utils.TIPO_COLOR_FONTE[tipo] ?: Color.WHITE

                    binding.tvType2.setBackgroundColor(corFundo)
                    binding.tvType2.setTextColor(corLetra)
                } else {
                    binding.tvType2.text = ""
                    binding.tvType2.visibility = View.GONE
                }

                Picasso.get()
                    .load(pokemon.sprites.other.officialartwork.front_default)
                    .placeholder(R.drawable.pokeball)
                    .into(binding.ivSprite)

            } else {
                binding.tvId.text = ""
                binding.tvName.text = getString(R.string.notfound)
                binding.tvType1.text = ""
                binding.tvType1.visibility = View.GONE
                binding.tvType2.text = ""
                binding.tvType2.visibility = View.GONE
                binding.ivSprite.setImageResource(R.drawable.inicio)

            }
        }

        // Inicia a busca pelo Pokémon
        binding.bPesquisar.setOnClickListener {
            pokePesquisar()
        }

    }

    private fun pokePesquisar() {
        val busca = binding.etBusca.text.toString().trim().lowercase()
        viewModel.fetchPokemon(busca)
    }
}