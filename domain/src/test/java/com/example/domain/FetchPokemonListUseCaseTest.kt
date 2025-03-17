package com.example.domain

import com.example.data.Pokemon
import com.example.data.PokemonList
import data.PokemonRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class FetchPokemonListUseCaseTest {
    private val repository: PokemonRepository = mock()
    private lateinit var sut: FetchPokemonListUseCase

    @Before
    fun setUp() {
        sut = FetchPokemonListUseCase(repository)
    }

    @Test
    fun `GIVEN correct data WHEN invoke() is called, THEN return the correct data`() =
        runTest {
            val listOfPokemon = PokemonList(listOf(Pokemon("pikachu", "abc.com")))
            whenever(repository.getListPokemon()).thenReturn(listOfPokemon)

            val result = sut()

            assertEquals(listOfPokemon, result)
            verify(repository).getListPokemon()
        }
}
