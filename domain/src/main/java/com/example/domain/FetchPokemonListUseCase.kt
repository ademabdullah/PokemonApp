package com.example.domain

import data.model.PokemonList
import data.PokemonRepository
import javax.inject.Inject

class FetchPokemonListUseCase @Inject constructor(
        private val repository: PokemonRepository,
    ) {
        suspend operator fun invoke(): Result<PokemonList> = repository.getPokemonList()
    }
