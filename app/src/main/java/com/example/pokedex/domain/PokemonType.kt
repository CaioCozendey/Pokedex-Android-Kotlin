package com.example.pokedex.domain

import java.util.*

data class PokemonType(
    val name: String
){
    val formattedName = name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}