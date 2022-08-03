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
                tipoUm.text = item.types[0].name.capitalize()
                mudaCorFundoType(item.types[0].name, tipoUm)

                if (item.types.size > 1) {
                    tipoDois.visibility = View.VISIBLE
                    tipoDois.text = item.types[1].name.capitalize()
                    mudaCorFundoType(item.types[1].name, tipoDois)
                } else {
                    tipoDois.visibility = View.GONE
                }
            }
        }

        @SuppressLint("ResourceAsColor")
        private fun mudaCorFundoType(tipo: String, background: TextView) {
            if (tipo == "fire") {
                background.setBackgroundResource(R.drawable.background_fire)
            } else if ( tipo == "water" ){
                background.setBackgroundResource(R.drawable.background_water)
            } else if ( tipo == "bug" ||  tipo == "grass" ){
                background.setBackgroundResource(R.drawable.brackground_grass_e_bug)
            } else if ( tipo == "poison" ){
                background.setBackgroundResource(R.drawable.brackground_poison)
            } else if ( tipo == "dark" ){
                background.setBackgroundResource(R.drawable.brackground_dark)
            } else if ( tipo == "electric" ){
                background.setBackgroundResource(R.drawable.brackground_eletricc)
            } else if ( tipo == "fairy" ){
                background.setBackgroundResource(R.drawable.brackground_fairy)
            } else if ( tipo == "fighting" ){
                background.setBackgroundResource(R.drawable.brackground_fighting)
            } else if ( tipo == "flying" ){
                background.setBackgroundResource(R.drawable.brackground_fly)
            } else if ( tipo == "ghost" ){
                background.setBackgroundResource(R.drawable.brackground_ghost)
            } else if ( tipo == "normal" ){
                background.setBackgroundResource(R.drawable.brackground_normal)
            } else if ( tipo == "ground" ){
                background.setBackgroundResource(R.drawable.brackground_ground)
            } else if ( tipo == "psychic"){
                background.setBackgroundResource(R.drawable.brackground_psychic)
            } else if ( tipo == "ice"){
                background.setBackgroundResource(R.drawable.brackground_ice)
            } else if ( tipo == "rock"){
                background.setBackgroundResource(R.drawable.brackground_rock)
            } else if ( tipo == "steel"){
                background.setBackgroundResource(R.drawable.brackground_steel)
            } else if ( tipo == "dragon"){
                background.setBackgroundResource(R.drawable.brackground_dragon)
            }
        }
    }
}