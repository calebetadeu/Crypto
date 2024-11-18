package com.example.crypto.crypto_tracker.data.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.crypto.crypto_tracker.data.dto.CoinDto
import com.example.crypto.crypto_tracker.data.dto.CoinPriceDto
import com.example.crypto.crypto_tracker.domain.Coin
import com.example.crypto.crypto_tracker.domain.CoinPrice
import java.time.Instant
import java.time.ZoneOffset

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr,
    )

}

@RequiresApi(Build.VERSION_CODES.O)
fun CoinPriceDto.toCoinPrice(): CoinPrice {
    return CoinPrice(
        priceUsd = priceUsd,
        dateTime = Instant.ofEpochSecond(time).atZone(ZoneOffset.UTC)

    )
}