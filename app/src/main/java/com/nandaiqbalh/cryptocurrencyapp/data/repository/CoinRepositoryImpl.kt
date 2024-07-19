package com.nandaiqbalh.cryptocurrencyapp.data.repository

import com.nandaiqbalh.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.nandaiqbalh.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.nandaiqbalh.cryptocurrencyapp.data.remote.dto.CoinDto
import com.nandaiqbalh.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
	private val api: CoinPaprikaApi,
) : CoinRepository {

	override suspend fun getCoins(): List<CoinDto> {
		return api.getCoin()
	}

	override suspend fun getCoinById(coinId: String): CoinDetailDto {
		return api.getCoinById(coinId)
	}
}