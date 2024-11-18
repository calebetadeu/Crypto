package com.example.crypto

import android.app.Application
import com.example.crypto.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class CryptoApp :Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CryptoApp)
            androidLogger()
            modules(appModule)
        }


    }

}