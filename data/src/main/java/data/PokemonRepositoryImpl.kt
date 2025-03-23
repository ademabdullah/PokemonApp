package com.example.data

import data.PokemonRepository
import data.model.PokemonList
import data.model.PokemonResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepositoryImpl @Inject constructor(
        private val apiService: PokemonApiService,
    ) : PokemonRepository {

    override suspend fun getPokemon(name: String): Result<PokemonResponse> {
        return apiService.getPokemon(name)
    }

    override suspend fun getPokemonList(): Result<PokemonList> {
        return apiService.getListPokemon() // API call
    }
}
