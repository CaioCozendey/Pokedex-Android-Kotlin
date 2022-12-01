package com.example.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class PokemonDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        setSupportActionBar(findViewById(R.id.toolbarDetails))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""

        val type2 = findViewById<TextView>(R.id.typeDoisDetails)

        val charTipos = 1

        if ( charTipos == 2){
            type2.visibility = View.VISIBLE
        }
        else{
            type2.visibility = View.GONE
        }
    }
}