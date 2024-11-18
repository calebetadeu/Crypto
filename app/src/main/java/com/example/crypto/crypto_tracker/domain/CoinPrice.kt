package com.example.crypto.crypto_tracker.domain

import java.time.ZonedDateTime

data class CoinPrice(
    val priceUsd:Double,
    val dateTime: ZonedDateTime
)
