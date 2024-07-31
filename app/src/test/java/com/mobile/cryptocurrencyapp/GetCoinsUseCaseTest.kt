package com.mobile.cryptocurrencyapp

import com.mobile.cryptocurrencyapp.common.Resource
import com.mobile.cryptocurrencyapp.data.remote.dto.CoinDto
import com.mobile.cryptocurrencyapp.domain.model.Coin
import com.mobile.cryptocurrencyapp.domain.repository.CoinRepository
import com.mobile.cryptocurrencyapp.domain.use_case.get_coins.GetCoinsUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetCoinsUseCaseTest {

    @Mock
    private lateinit var repository: CoinRepository

    private lateinit var getCoinsUseCase: GetCoinsUseCase

    @Before
    fun setUp() {
        getCoinsUseCase = GetCoinsUseCase(repository)
    }

    @Test
    fun `invoke returns coin list on success`() = runBlocking {
        // Prepare test data
        val coinDto = CoinDto(
            id = "bitcoin",
            is_active = true,
            is_new = false,
            name = "Bitcoin",
            rank = 1,
            symbol = "BTC",
            type = "cryptocurrency"
        )
        val expectedCoin = Coin(
            id = "bitcoin",
            is_active = true,
            name = "Bitcoin",
            rank = 1,
            symbol = "BTC"
        )

        whenever(repository.getCoins()).thenReturn(listOf(coinDto))

        // Execute use case
        val result = getCoinsUseCase()

        // Assert
        assertTrue(result is Resource.Success)
        assertEquals(listOf(expectedCoin), (result as Resource.Success).data)
    }
}
