package com.example.data

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doThrow
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class PokemonRepositoryTest {
    private val mockApiService: PokemonApiService = mock()
    private lateinit var repository: PokemonRepositoryImpl

    @Before
    fun setUp() {
        repository = PokemonRepositoryImpl(mockApiService)
    }

    @Test
    fun `GIVEN expected data WHEN getPokemon() is called, THEN return expected data`() =
        runTest {
            // given
            val expectedPokemon = PokemonResponse("pikachu", 4, 60, sprites = Sprites("pikachu.png"))

//            whenever(mockApiService.getPokemon("pikachu")).thenReturn(expectedPokemon)

            // when
            val result = repository.getPokemon("pikachu")
            println(result)

            // then
            assertEquals(expectedPokemon, result)
            verify(mockApiService).getPokemon("pikachu")
        }

    @Test
    fun `getPokemon() returns failure when expected data not returned`() =
        runBlocking {
            // given
            val badResponse = RuntimeException("Network Error")
            doThrow(badResponse).whenever(mockApiService).getPokemon("pikachu")

            // when
            val thrownException =
                assertThrows(RuntimeException::class.java) {
                    runBlocking { repository.getPokemon("pikachu") }
                }

            // then: Verify an exception was thrown
            verify(mockApiService, times(1)).getPokemon("pikachu")
            assertNotNull(thrownException)
            assertEquals("Network Error", thrownException.message)
        }
}
