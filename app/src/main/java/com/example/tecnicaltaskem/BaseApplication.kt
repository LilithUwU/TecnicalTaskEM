package com.example.tecnicaltaskem

import android.app.Application
import com.example.tecnicaltaskem.data.AppDatabase
import com.example.tecnicaltaskem.data.repository.Repository
import com.example.tecnicaltaskem.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import kotlin.getValue

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(appModule)
        }
    }
}
