package com.nandaiqbalh.cryptocurrencyapp.di

import com.nandaiqbalh.cryptocurrencyapp.common.Constants.BASE_URL
import com.nandaiqbalh.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.nandaiqbalh.cryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.nandaiqbalh.cryptocurrencyapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

	@Provides
	@Singleton
	fun providePaprikaApi(): CoinPaprikaApi {
		return Retrofit.Builder().baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create()).build()
			.create(CoinPaprikaApi::class.java)
	}

	@Provides
	@Singleton
	fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository{
		return CoinRepositoryImpl(api)
	}

}