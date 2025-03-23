package com.example.domain

import data.model.PokemonResponse
import data.PokemonRepository
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
        private val repository: PokemonRepository,
    ) {
        suspend operator fun invoke(pokemonName: String): Result<PokemonResponse> = repository.getPokemon(pokemonName)
    }
