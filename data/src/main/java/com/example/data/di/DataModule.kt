package com.example.data.di

import androidx.room.Room
import com.example.data.AppDatabase
import com.example.data.network.CourseApi
import com.example.data.network.MockInterceptor
import com.example.data.repository.CourseRepositoryImpl
import com.example.domain.repository.CourseRepository
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    // Database
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "app_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<AppDatabase>().courseDao() }

    // Network
    single {
        OkHttpClient.Builder()
            .addInterceptor(MockInterceptor())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.mock.com/") // Dummy base URL
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CourseApi::class.java)
    }

    // Repository
    single<CourseRepository> { CourseRepositoryImpl(get(), get()) }
}
