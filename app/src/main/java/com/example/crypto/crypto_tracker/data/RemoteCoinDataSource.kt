package com.example.crypto.crypto_tracker.data

import com.example.crypto.core.data.networking.constructUrl
import com.example.crypto.core.data.networking.safeCall
import com.example.crypto.core.util.NetworkError
import com.example.crypto.core.util.Result
import com.example.crypto.core.util.map
import com.example.crypto.crypto_tracker.data.dto.CoinsResponseDto
import com.example.crypto.crypto_tracker.data.mappers.toCoin
import com.example.crypto.crypto_tracker.domain.Coin
import com.example.crypto.crypto_tracker.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val client: HttpClient

):CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            client.get(
                urlString = constructUrl("/assets")
            )
        }.map {response->
            response.data.map {
                it.toCoin()
            }

        }
    }

}