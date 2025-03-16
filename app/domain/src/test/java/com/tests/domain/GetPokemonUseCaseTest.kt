package com.tests.domain

import com.example.data.PokemonResponse
import com.example.data.Sprites
import com.example.domain.GetPokemonUseCase
import data.PokemonRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


@ExperimentalCoroutinesApi
class GetPokemonUseCaseTest {

    private val repository: PokemonRepository = mock ()
    private lateinit var sut: GetPokemonUseCase

    @Before
    fun setUp() {
        sut = GetPokemonUseCase(repository)
    }

    @Test
    fun `GIVEN correct data WHEN invoke() is called, THEN return true`() = runTest {
        val pokemonName = "pikachu"
        val expectedPokemon = PokemonResponse("pikachu", 4, 60, sprites = Sprites("pikachu.png"))
        whenever(repository.getPokemon(pokemonName)).doReturn(expectedPokemon)

        val result = sut(pokemonName)

        assertEquals(expectedPokemon, result)
        verify(repository).getPokemon(pokemonName)
    }
}