package com.example.data

data class PokemonResponse(
    val name: String,
    val height: Int,
    val weight: Int,
    val sprites: Sprites,
)

data class Sprites(
    val front_default: String,
)

data class Pokemon(
    val name: String,
    val url: String
)

data class PokemonList(
    val results: List<Pokemon>,

    )