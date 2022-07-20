package com.example.pokedex.domain

data class Pokemon(
    val numero: Int? = null,
    val nome: String,
    val tipo: List<PokemonTipo>
){
    val formattedName = nome

    val formattedNumber = numero.toString().padStart(3, '0')

    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"
}

