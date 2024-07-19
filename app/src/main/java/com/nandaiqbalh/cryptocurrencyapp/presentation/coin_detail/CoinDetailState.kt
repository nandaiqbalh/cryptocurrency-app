package com.nandaiqbalh.cryptocurrencyapp.presentation.coin_detail

import com.nandaiqbalh.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
	val isLoading: Boolean = false,
	val coins:CoinDetail? = null,
	val error: String = "",

	)