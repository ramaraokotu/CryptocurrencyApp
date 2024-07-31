package com.mobile.cryptocurrencyapp.domain.repository

import com.mobile.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.mobile.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}