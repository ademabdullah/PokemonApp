package com.example.data

class PokemonRepository(
    private val apiService: PokemonApiService,
) {
    suspend fun getPokemon(name: String): PokemonResponse {
        try {
            return apiService.getPokemon(name)
        } catch (error: Throwable) {
            println("Unexpected error while handling request:$error")
            throw error
        }
    }

    suspend fun getListPokemon(): PokemonList {
        try {
        return apiService.getListPokemon() // API call
        }
        catch (error: Throwable) {
            println("Unexpected error while handling request:$error")
            throw error
        }
    }
}
