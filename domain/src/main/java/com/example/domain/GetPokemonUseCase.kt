package com.example.domain

import com.example.data.PokemonResponse
import data.PokemonRepository
import javax.inject.Inject

class GetPokemonUseCase
    @Inject
    constructor(
        private val repository: PokemonRepository,
    ) {
        suspend operator fun invoke(pokemonName: String): PokemonResponse = repository.getPokemon(pokemonName)
    }
