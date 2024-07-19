package com.nandaiqbalh.cryptocurrencyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nandaiqbalh.cryptocurrencyapp.presentation.coin_detail.CoinDetailScreen
import com.nandaiqbalh.cryptocurrencyapp.presentation.coin_list.CoinListScreen
import com.nandaiqbalh.cryptocurrencyapp.presentation.ui.theme.CryptocurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			CryptocurrencyAppTheme {
				Surface(color = MaterialTheme.colorScheme.background) {
					val navController = rememberNavController()

					NavHost(
						navController = navController,
						startDestination = Screen.CoinListScreen.route
					) {

						composable(
							route = Screen.CoinListScreen.route
						) {
							CoinListScreen(navController)
						}

						composable(
							route = Screen.CoinDetailScreen.route + "/{coinId}"
						) {
							CoinDetailScreen()
						}

					}
				}
			}
		}
	}
}

