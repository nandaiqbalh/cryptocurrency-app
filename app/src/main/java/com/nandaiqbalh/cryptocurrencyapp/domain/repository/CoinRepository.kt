package com.nandaiqbalh.cryptocurrencyapp.domain.repository

import com.nandaiqbalh.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.nandaiqbalh.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

	suspend fun getCoins(): List<CoinDto>
	suspend fun getCoinById(coinId: String): CoinDetailDto

}