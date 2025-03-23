package data

import data.model.PokemonList
import data.model.PokemonResponse

interface PokemonRepository {
    suspend fun getPokemon(name: String): Result<PokemonResponse>

    suspend fun getPokemonList(): Result<PokemonList>
}
