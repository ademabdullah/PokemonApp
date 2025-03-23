package data.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    val name: String,
    val height: Int,
    val weight: Int,
    val sprites: Sprites,
)

data class Sprites(
    val other: Other
)

data class Pokemon(
    val name: String,
    val url: String,
)

data class PokemonList(
    val results: List<Pokemon>,
)

data class OfficialArtwork (
    @SerializedName("front_default") val frontDefault: String,
    @SerializedName("front_shiny") val frontShiny: String,
)

data class Other (
    @SerializedName("official-artwork") val officalArtwork: OfficialArtwork,
)
