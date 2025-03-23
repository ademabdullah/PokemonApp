package com.tests.domain

import com.example.domain.GetPokemonUseCase
import data.PokemonRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class GetPokemonUseCaseTest {
    private val mockPokemonRepository: PokemonRepository = mock()
    private lateinit var sut: GetPokemonUseCase

    @Before
    fun setUp() {
        sut = GetPokemonUseCase(mockPokemonRepository)
    }

    @Test
    fun `GIVEN getPokemon returns success WHEN invoke is called, THEN return success`() = runTest {
        sut("pikachu").isSuccess

    }

    @Test
    fun `GIVEN getPokemon returns failure WHEN invoke is called, THEN return failure`() = runTest {
        whenever(mockPokemonRepository.getPokemonList()).doReturn(Result.failure(Exception()))

        sut("pikachu").isFailure
    }
}