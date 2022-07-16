package com.example.pokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.domain.Pokemon
import com.example.pokedex.domain.PokemonTipo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerViewPokemon = findViewById<RecyclerView>(R.id.recyclerViewPokes)

        val charmander = Pokemon(
            "Charmander",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
            4,
            listOf(
                PokemonTipo("Fogo"),
                PokemonTipo("Água")
            )
        )
        val listaPokemon = listOf( charmander, charmander, charmander,  charmander, charmander, charmander)

        val layoutManager = LinearLayoutManager(this)

        recyclerViewPokemon.layoutManager = layoutManager
        recyclerViewPokemon.adapter = PokemonAdapter(listaPokemon)
    }
}