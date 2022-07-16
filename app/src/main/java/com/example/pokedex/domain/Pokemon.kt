package com.example.pokedex.domain

data class Pokemon (
    val id: Int = 0,
    val nome: String? = null,
    val imagemUrl: String? = null,
    val numero: Int? = null,
    val tipo: List<PokemonTipo>
){
    val formattedNumber = numero.toString().padStart(3, '0')
}

