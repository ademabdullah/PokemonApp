package com.example.domain

import com.example.data.PokemonList
import data.PokemonRepository
import javax.inject.Inject

class FetchPokemonListUseCase @Inject constructor(
        private val repository: PokemonRepository,
    ) {
        suspend operator fun invoke(): PokemonList = repository.getListPokemon()
    }
