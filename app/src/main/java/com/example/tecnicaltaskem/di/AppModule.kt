package com.example.tecnicaltaskem.di


import androidx.room.Room
import com.example.tecnicaltaskem.data.AppDatabase
import com.example.tecnicaltaskem.data.local.dao.CourseDao
import com.example.tecnicaltaskem.data.repository.IRepository
import com.example.tecnicaltaskem.data.repository.Repository
import com.example.tecnicaltaskem.presentation.HomeFragmentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModelOf
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

    single<CourseDao> { get<AppDatabase>().courseDao() }

    single<IRepository> {
        Repository(get())
    }

    viewModelOf(::HomeFragmentViewModel)
}