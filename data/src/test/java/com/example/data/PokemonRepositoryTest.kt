package com.example.data

import data.model.OfficialArtwork
import data.model.Other
import data.model.PokemonResponse
import data.model.Sprites
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class PokemonRepositoryTest {
    val expectedPokemon = PokemonResponse(
        name = "pikachu",
        height = 4,
        weight = 60,
        sprites = Sprites(Other((OfficialArtwork("a", "b"))))
    )

    private val mockGetPokemonAPI: PokemonApiService = mock {
        onBlocking { getPokemon("pikachu") } doReturn Result.success((expectedPokemon))
    }

    private lateinit var sut: PokemonRepositoryImpl

    @Before
    fun setUp() {
        sut = PokemonRepositoryImpl(mockGetPokemonAPI)
    }

    @Test
    fun `GIVEN expected data WHEN getPokemon() is called, THEN return expected data`() = runTest {
            //given
            whenever(mockGetPokemonAPI.getPokemon("pikachu")).thenReturn(Result.success(expectedPokemon))

            //when
            val outcome = sut.getPokemon("pikachu")

            //then
            assertTrue(outcome.isSuccess)
            assertEquals(expectedPokemon, outcome.getOrNull())
            verify(mockGetPokemonAPI).getPokemon("pikachu")
    }

    @Test
    fun `GIVEN expected data WHEN getPokemon() is called, THEN a failure is returned` () = runTest {
        //given
        whenever(mockGetPokemonAPI.getPokemon("pikachu")).doReturn(Result.failure(exception = Exception()))

        //when
        val outcome = sut.getPokemon("pikachu")

        //then
        assertTrue(outcome.isFailure)
        verify(mockGetPokemonAPI).getPokemon("pikachu")
    }
}
