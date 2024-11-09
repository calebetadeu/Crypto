package com.example.crypto.crypto_tracker.presentation.coin_list

import com.example.crypto.crypto_tracker.presentation.models.CoinUi

sealed interface CoinListAction {
    data class CoinClicked(val coin: CoinUi) : CoinListAction

}