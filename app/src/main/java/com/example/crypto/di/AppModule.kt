package com.example.crypto.di

import com.example.crypto.core.data.networking.HttpClientFactory
import com.example.crypto.crypto_tracker.data.RemoteCoinDataSource
import com.example.crypto.crypto_tracker.domain.CoinDataSource
import com.example.crypto.crypto_tracker.presentation.coin_list.CoinListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module{
    single{ HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()
    viewModelOf(::CoinListViewModel)
}