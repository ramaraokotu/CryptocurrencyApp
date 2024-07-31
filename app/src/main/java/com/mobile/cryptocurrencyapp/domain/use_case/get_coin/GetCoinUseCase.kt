package com.mobile.cryptocurrencyapp.domain.use_case.get_coin

import com.mobile.cryptocurrencyapp.common.Resource
import com.mobile.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.mobile.cryptocurrencyapp.domain.model.CoinDetail
import com.mobile.cryptocurrencyapp.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend operator fun invoke(coinId: String): Resource<CoinDetail> {
        return try {
            val coin = repository.getCoinById(coinId).toCoinDetail()
            Resource.Success(coin)
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            Resource.Error("Couldn't reach server. Check your internet connection.")
        } catch (e: Exception) {
            Resource.Error("An unexpected error occurred")
        }
    }
}