package com.example.pokedex.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.PokemonDetailsActivity
import com.example.pokedex.R
import com.example.pokedex.domain.Pokemon
import com.example.pokedex.ViewModel.PokemonViewModel
import com.example.pokedex.ViewModel.PokemonViewModelFactory


class MainActivity : AppCompatActivity(){

    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.recyclerViewPokes)
    }

    private val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.pokemons.observe(this, this::loadRecyclerView)

        val ball = findViewById<ImageView>(R.id.pokeballLogo)


        ball.setOnClickListener {
            val intent = Intent(this, PokemonDetailsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadRecyclerView(pokemons: List<Pokemon?>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}