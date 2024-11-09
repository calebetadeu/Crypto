package com.example.crypto.crypto_tracker.data.mappers

import com.example.crypto.crypto_tracker.data.dto.CoinDto
import com.example.crypto.crypto_tracker.domain.Coin

fun CoinDto.toCoin(): Coin{
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