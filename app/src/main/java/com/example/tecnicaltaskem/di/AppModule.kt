package com.example.tecnicaltaskem.di

import com.example.tecnicaltaskem.AppViewModel
import com.example.tecnicaltaskem.presentation.helpers.mockCourses
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { mockCourses }
    viewModel { AppViewModel(get(), get()) }
}
