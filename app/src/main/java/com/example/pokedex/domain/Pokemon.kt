package com.example.pokedex.domain

data class Pokemon (
    val nome: String,
    val imagemUrl: String,
    val numero: Int,
    val tipo: List<PokemonTipo>
){
    val formattedNumber = numero.toString().padStart(3, '0')
}

