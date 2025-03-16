package data

import com.example.data.PokemonApiService
import com.example.data.PokemonList
import com.example.data.PokemonResponse

interface PokemonRepository {

    suspend fun getPokemon(name: String): PokemonResponse

    suspend fun getListPokemon(): PokemonList


}