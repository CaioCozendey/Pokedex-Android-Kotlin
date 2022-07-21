package com.example.pokedex.domain

import java.util.*

data class Pokemon(
    val numero: Int? = null,
    val nome: String,
    val tipo: List<PokemonTipo>
){
    val formattedName = nome.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(
            Locale.getDefault()
        ) else it.toString()
    }

    val formattedNumber = numero.toString().padStart(3, '0')

    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"
}

