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
    val TYPE_WEAKNESSES_RESISTANCES_IMMUNITIES  = mapOf(
        "Normal" to mapOf(
            "weaknesses" to listOf("Fighting"),
            "resistances" to emptyList<String>(),
            "immunities" to listOf("Ghost")
        ),
        "Fire" to mapOf(
            "weaknesses" to listOf("Water", "Ground", "Rock"),
            "resistances" to listOf("Fire", "Grass", "Ice", "Bug", "Steel", "Fairy"),
            "immunities" to emptyList<String>()
        ),
        "Water" to mapOf(
            "weaknesses" to listOf("Electric", "Grass"),
            "resistances" to listOf("Fire", "Water", "Ice", "Steel"),
            "immunities" to emptyList<String>()
        ),
        "Electric" to mapOf(
            "weaknesses" to listOf("Ground"),
            "resistances" to listOf("Electric", "Flying", "Steel"),
            "immunities" to emptyList<String>()
        ),
        "Grass" to mapOf(
            "weaknesses" to listOf("Fire", "Ice", "Poison", "Flying", "Bug"),
            "resistances" to listOf("Water", "Electric", "Grass", "Ground"),
            "immunities" to emptyList<String>()
        ),
        "Ice" to mapOf(
            "weaknesses" to listOf("Fire", "Fighting", "Rock", "Steel"),
            "resistances" to listOf("Ice"),
            "immunities" to emptyList<String>()
        ),
        "Fighting" to mapOf(
            "weaknesses" to listOf("Flying", "Psychic", "Fairy"),
            "resistances" to listOf("Bug", "Rock", "Dark"),
            "immunities" to emptyList<String>()
        ),
        "Poison" to mapOf(
            "weaknesses" to listOf("Ground", "Psychic"),
            "resistances" to listOf("Grass", "Fighting", "Poison", "Bug", "Fairy"),
            "immunities" to emptyList<String>()
        ),
        "Ground" to mapOf(
            "weaknesses" to listOf("Water", "Grass", "Ice"),
            "resistances" to listOf("Poison", "Rock"),
            "immunities" to listOf("Electric")
        ),
        "Flying" to mapOf(
            "weaknesses" to listOf("Electric", "Ice", "Rock"),
            "resistances" to listOf("Grass", "Fighting", "Bug"),
            "immunities" to listOf("Ground")
        ),
        "Psychic" to mapOf(
            "weaknesses" to listOf("Bug", "Ghost", "Dark"),
            "resistances" to listOf("Fighting", "Psychic"),
            "immunities" to emptyList<String>()
        ),
        "Bug" to mapOf(
            "weaknesses" to listOf("Fire", "Flying", "Rock"),
            "resistances" to listOf("Grass", "Fighting", "Ground"),
            "immunities" to emptyList<String>()
        ),
        "Rock" to mapOf(
            "weaknesses" to listOf("Water", "Grass", "Fighting", "Ground", "Steel"),
            "resistances" to listOf("Normal", "Fire", "Poison", "Flying"),
            "immunities" to emptyList<String>()
        ),
        "Ghost" to mapOf(
            "weaknesses" to listOf("Ghost", "Dark"),
            "resistances" to listOf("Poison", "Bug"),
            "immunities" to listOf("Normal", "Fighting")
        ),
        "Dragon" to mapOf(
            "weaknesses" to listOf("Ice", "Dragon", "Fairy"),
            "resistances" to listOf("Fire", "Water", "Electric", "Grass"),
            "immunities" to emptyList<String>()
        ),
        "Dark" to mapOf(
            "weaknesses" to listOf("Fighting", "Bug", "Fairy"),
            "resistances" to listOf("Ghost", "Dark"),
            "immunities" to listOf("Psychic")
        ),
        "Steel" to mapOf(
            "weaknesses" to listOf("Fire", "Fighting", "Ground"),
            "resistances" to listOf("Normal", "Grass", "Ice", "Flying", "Psychic", "Bug", "Rock", "Dragon", "Steel", "Fairy"),
            "immunities" to listOf("Poison")
        ),
        "Fairy" to mapOf(
            "weaknesses" to listOf("Poison", "Steel"),
            "resistances" to listOf("Fighting", "Bug", "Dark"),
            "immunities" to listOf("Dragon")
        )
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