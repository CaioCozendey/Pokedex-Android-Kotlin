package com.example.pokedex.view

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.domain.Pokemon

class PokemonAdapter(
    private val items: List<Pokemon?>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_pokemon, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bindView(item: Pokemon?) = with(itemView) {
            val imagem = findViewById<ImageView>(R.id.pokeImage)
            val numero = findViewById<TextView>(R.id.numeroPokemon)
            val nome = findViewById<TextView>(R.id.nomePokemon)
            val tipoUm = findViewById<TextView>(R.id.typeUm)
            val tipoDois = findViewById<TextView>(R.id.typeDois)

            item?.let {
                Glide.with(itemView.context).load(it.imageUrl).into(imagem)

                numero.text = "Nº ${item.formattedNumber}"
                nome.text = item.formattedName
                tipoUm.text = item.types[0].formattedName
                Log.e("POKEMON_API", "$tipoUm")

                if (item.types.size > 1) {
                    tipoDois.visibility = View.VISIBLE
                    tipoDois.text = item.types[1].formattedName
                } else {
                    tipoDois.visibility = View.GONE
                }
            }
        }
    }
}