package com.example.data

import data.PokemonRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepositoryImpl
    @Inject
    constructor(
        private val apiService: PokemonApiService,
    ) : PokemonRepository {
        override suspend fun getPokemon(name: String): PokemonResponse {
            try {
                return apiService.getPokemon(name)
            } catch (error: Throwable) {
                println("Unexpected error while handling request:$error")
                throw error
            }
        }

        override suspend fun getListPokemon(): PokemonList {
            try {
                return apiService.getListPokemon() // API call
            } catch (error: Throwable) {
                println("Unexpected error while handling request:$error")
                throw error
            }
        }
    }
