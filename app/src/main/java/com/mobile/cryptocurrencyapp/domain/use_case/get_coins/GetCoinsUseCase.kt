package com.mobile.cryptocurrencyapp.domain.use_case.get_coins

import com.mobile.cryptocurrencyapp.common.Resource
import com.mobile.cryptocurrencyapp.data.remote.dto.toCoin
import com.mobile.cryptocurrencyapp.domain.model.Coin
import com.mobile.cryptocurrencyapp.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend operator fun invoke(): Resource<List<Coin>> {
        return try {
            val coins = repository.getCoins().map { it.toCoin() }
            Resource.Success(coins)
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            Resource.Error("Couldn't reach server. Check your internet connection.")
        }
    }
}