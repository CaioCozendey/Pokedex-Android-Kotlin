package br.com.fabricadesinapse.pokedex_android.api

import com.example.pokedex.api.model.PokemonApiResult
import com.example.pokedex.api.model.PokemonsApiResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokemonService {
    @GET("pokemon")
    fun listPokemons(@Query("limit") limit: Int): retrofit2.Call<PokemonsApiResult>

    @GET("pokemon/{number}")
    fun getPokemon(@Path("number") number: Int): retrofit2.Call<PokemonApiResult>
}
