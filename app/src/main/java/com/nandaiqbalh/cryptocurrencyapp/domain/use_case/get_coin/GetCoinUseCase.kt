package com.nandaiqbalh.cryptocurrencyapp.domain.use_case.get_coin

import com.nandaiqbalh.cryptocurrencyapp.common.Resource
import com.nandaiqbalh.cryptocurrencyapp.data.remote.dto.toCoilDetail
import com.nandaiqbalh.cryptocurrencyapp.domain.model.CoinDetail
import com.nandaiqbalh.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
	private val repository: CoinRepository,
) {

	operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
		try {
			emit(Resource.Loading())
			val coin = repository.getCoinById(coinId).toCoilDetail()
			emit(Resource.Success(coin))

		} catch (e: HttpException) {
			emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
		} catch (e: IOException) {
			emit(Resource.Error("Couldn't reach server. Check your internet connection"))
		}
	}
}