package com.example.data

import data.model.Pokemon
import data.model.PokemonList
import data.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {
    companion object {
        const val POKEMON_LIST = "/pokemon"
        const val POKEMON_DETAILS = "/pokemon/{name}"
    }

    @GET(POKEMON_DETAILS)
    suspend fun getPokemon(@Path("name") name: String): Result<PokemonResponse>

    @GET(POKEMON_LIST)
    suspend fun getListPokemon(): Result<PokemonList>
}
