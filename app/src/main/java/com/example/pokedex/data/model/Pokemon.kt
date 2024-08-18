package com.example.pokedex.data.model

import com.google.gson.annotations.SerializedName

data class Pokemon(

    val id: Int,
    val name: String,
    val sprites: Sprites,
    val types: List<PokemonTypeSlot>,
)

data class Other(
    @SerializedName("official-artwork") val officialartwork: OfficialArtwork
)

data class OfficialArtwork(
    val front_default: String
)

data class Sprites(

    val other: Other,

    )

data class PokemonTypeSlot(
    val slot: Int, val type: Type
)

data class Type(
    val name: String, val url: String
)