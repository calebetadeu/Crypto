package com.example.crypto.crypto_tracker.domain

import com.example.crypto.core.util.NetworkError
import com.example.crypto.core.util.Result


interface CoinDataSource{
    suspend fun getCoins(): Result<List<Coin>, NetworkError>

}