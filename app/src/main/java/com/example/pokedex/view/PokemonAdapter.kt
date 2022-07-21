package com.example.pokedex.view

import android.annotation.SuppressLint
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
    private val pokemon: List<Pokemon?>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_pokemon, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = pokemon[position]

        holder.bindView(item)
    }

    override fun getItemCount() = pokemon.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bindView(item: Pokemon?) = with(itemView){
            val imagem = findViewById<ImageView>(R.id.pokeImage)
            val nome = findViewById<TextView>(R.id.nomePokemon)
            val numero = findViewById<TextView>(R.id.numeroPokemon)
            val tipoum = findViewById<TextView>(R.id.tipoPokemonUm)
            val tipodois = findViewById<TextView>(R.id.tipoPokemonDois)

            item?.let {
                Glide.with(itemView.context).load(it.imageUrl).into(imagem)

                numero.text = "Nº ${item.formattedNumber}"
                nome.text = item.formattedName
                tipoum.text = item.tipo[0].nomeTipo

                if (item.tipo.size > 1) {
                    tipodois.visibility = View.VISIBLE
                    tipodois.text = item.tipo[1].nomeTipo
                } else {
                    tipodois.visibility = View.GONE
                }
            }
        }


    }
}