package com.example.tecnicaltaskem

import android.app.Application
import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import com.example.tecnicaltaskem.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(dataModule, domainModule, appModule))
        }
    }
}
