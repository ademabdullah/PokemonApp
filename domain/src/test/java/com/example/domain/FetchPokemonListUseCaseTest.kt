package com.example.domain

import data.PokemonRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class FetchPokemonListUseCaseTest {
    private val mockPokemonRepository: PokemonRepository = mock()
    private lateinit var sut: FetchPokemonListUseCase

    @Before
    fun setUp() {
        sut = FetchPokemonListUseCase(mockPokemonRepository)
    }

    @Test
    fun `GIVEN getPokemonList returns success WHEN invoke is called, THEN return success`() = runTest {
        sut().isSuccess

        }

    @Test
    fun `GIVEN getPokemonList returns failure WHEN invoke is called, THEN return failure`() = runTest {
        whenever(mockPokemonRepository.getPokemonList()).doReturn(Result.failure(Exception()))

        sut().isFailure
    }
}
