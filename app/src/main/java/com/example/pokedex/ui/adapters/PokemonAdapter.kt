package com.example.pokedex.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pokedex.R
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.databinding.ActivityPokemonItemBinding
import com.example.pokedex.utils.Utils
import com.squareup.picasso.Picasso

class PokemonAdapter(
    private val pokemons: List<Pokemon>,
    private val clique: (String) -> Unit
) :
    Adapter<PokemonAdapter.PokemonViewHolder>() {


    inner class PokemonViewHolder(
        private val binding: ActivityPokemonItemBinding
    ) : ViewHolder(binding.root) {
        val tvName: TextView = binding.tvName
        val tvId: TextView = binding.tvId
        val tvType1: TextView = binding.tvType1
        val tvType2: TextView = binding.tvType2
        val ivImage: ImageView = binding.ivImage
        val cItemPoke: ConstraintLayout = binding.cItemPoke

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val itemView = ActivityPokemonItemBinding.inflate(layoutInflater, parent, false)
        return PokemonViewHolder(itemView)
    }


    override fun onBindViewHolder(binding: PokemonViewHolder, position: Int) {

        // inicio
        val nome = Utils.formatarPrimeiraLetraMaiuscula(pokemons[position].name)
        binding.tvName.text = nome

        val id = Utils.formatarNumero(pokemons[position].id)
        binding.tvId.text = id

        if (pokemons[position].types.isNotEmpty()) {
            val tipo = pokemons[position].types[0].type.name
            binding.tvType1.text = Utils.formatarPrimeiraLetraMaiuscula(tipo)
            val corFundo = Utils.TIPO_COLOR_FUNDO[tipo] ?: Color.WHITE
            val corLetra = Utils.TIPO_COLOR_FONTE[tipo] ?: Color.WHITE

            binding.tvType1.setBackgroundColor(corFundo)
            binding.tvType1.setTextColor(corLetra)
        } else {
            binding.tvType1.text = ""
        }
        if (pokemons[position].types.size > 1) {

            val tipo = pokemons[position].types[1].type.name
            binding.tvType2.text = Utils.formatarPrimeiraLetraMaiuscula(tipo)
            val corFundo = Utils.TIPO_COLOR_FUNDO[tipo] ?: Color.WHITE
            val corLetra = Utils.TIPO_COLOR_FONTE[tipo] ?: Color.WHITE

            binding.tvType2.setBackgroundColor(corFundo)
            binding.tvType2.setTextColor(corLetra)
        } else {
            binding.tvType2.text = ""
            binding.tvType2.visibility = View.GONE
        }

        Picasso.get()
            .load(pokemons[position].sprites.other.officialartwork.front_default)
            .placeholder(R.drawable.pokeball)
            .into(binding.ivImage)

        binding.cItemPoke.setOnClickListener {
            val pokeid = pokemons[position].id.toString()
            clique(pokeid)
        }

        //fim
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }
}