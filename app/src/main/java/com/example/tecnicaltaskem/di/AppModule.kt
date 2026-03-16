package com.example.tecnicaltaskem.di


import android.app.Application
import androidx.room.Room
import com.example.tecnicaltaskem.data.AppDatabase
import com.example.tecnicaltaskem.data.repository.IRepository
import com.example.tecnicaltaskem.data.repository.Repository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "app_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().courseDao() }

    // Bind Repository to IRepository interface
    single<IRepository> { Repository(get()) }
}