package com.example.pokedex.utils

import android.graphics.Color

object Utils {
    val TIPO_COLOR_FONTE = mapOf(
        "fire" to Color.BLACK,
        "water" to Color.WHITE,
        "grass" to Color.BLACK,
        "electric" to Color.BLACK,
        "ice" to Color.BLACK,
        "fighting" to Color.WHITE,
        "poison" to Color.WHITE,
        "ground" to Color.BLACK,
        "flying" to Color.BLACK,
        "psychic" to Color.BLACK,
        "bug" to Color.BLACK,
        "rock" to Color.WHITE,
        "ghost" to Color.WHITE,
        "dragon" to Color.WHITE,
        "dark" to Color.WHITE,
        "steel" to Color.BLACK,
        "fairy" to Color.BLACK
    )
    val TIPO_COLOR_FUNDO = mapOf(
        "fire" to Color.parseColor("#F08030"),
        "water" to Color.parseColor("#6890F0"),
        "grass" to Color.parseColor("#78C850"),
        "electric" to Color.parseColor("#F8D030"),
        "ice" to Color.parseColor("#98D8D8"),
        "fighting" to Color.parseColor("#C03028"),
        "poison" to Color.parseColor("#A040A0"),
        "ground" to Color.parseColor("#E0C068"),
        "flying" to Color.parseColor("#A890F0"),
        "psychic" to Color.parseColor("#F85888"),
        "bug" to Color.parseColor("#A8B820"),
        "rock" to Color.parseColor("#B8A038"),
        "ghost" to Color.parseColor("#705898"),
        "dragon" to Color.parseColor("#7038F8"),
        "dark" to Color.parseColor("#705848"),
        "steel" to Color.parseColor("#B8B8D0"),
        "fairy" to Color.parseColor("#EE99AC")
    )

    fun formatarNumero(numero: Int): String {
        return "N° ${String.format("%04d", numero)}"
    }

    fun formatarPrimeiraLetraMaiuscula(nome: String): String {
        return nome.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    }
}