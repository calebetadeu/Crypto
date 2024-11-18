package com.example.crypto.crypto_tracker.presentation.coin_list

import com.example.crypto.core.domain.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError) : CoinListEvent
}