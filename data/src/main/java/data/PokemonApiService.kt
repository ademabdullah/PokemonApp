package com.example.data

import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {
    companion object {
        const val POKEMON_LIST = "/pokemon"
        const val POKEMON_DETAILS = "/pokemon/{name}"
    }

    @GET(POKEMON_DETAILS)
    suspend fun getPokemon(
        @Path("name") name: String,
    ): PokemonResponse

    @GET(POKEMON_LIST)
    suspend fun getListPokemon(): PokemonList
}
