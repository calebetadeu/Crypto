package com.example.crypto.crypto_tracker.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.crypto.core.data.networking.constructUrl
import com.example.crypto.core.data.networking.safeCall
import com.example.crypto.core.domain.NetworkError
import com.example.crypto.core.domain.Result
import com.example.crypto.core.domain.map
import com.example.crypto.crypto_tracker.data.dto.CoinHistoryDto
import com.example.crypto.crypto_tracker.data.dto.CoinsResponseDto
import com.example.crypto.crypto_tracker.data.mappers.toCoin
import com.example.crypto.crypto_tracker.data.mappers.toCoinPrice
import com.example.crypto.crypto_tracker.domain.Coin
import com.example.crypto.crypto_tracker.domain.CoinDataSource
import com.example.crypto.crypto_tracker.domain.CoinPrice
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import java.time.ZoneId
import java.time.ZonedDateTime

class RemoteCoinDataSource(
    private val client: HttpClient

) : CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            client.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map {
                it.toCoin()
            }

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError> {
        val startMillis = start.withZoneSameInstant(ZoneId.of("UTC")).toInstant().toEpochMilli()
        val endMillis = end.withZoneSameInstant(ZoneId.of("UTC")).toInstant().toEpochMilli()

        return safeCall<CoinHistoryDto> {
            client.get(
                urlString = constructUrl("/assets/$coinId/history")
            ) {
                parameter("interval", "h6")
                parameter("start", startMillis)
                parameter("end", endMillis)
            }
        }.map { response ->
            response.data.map { it.toCoinPrice() }
        }

    }

}