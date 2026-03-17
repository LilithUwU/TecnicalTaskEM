package com.example.domain.di

import com.example.domain.usecase.GetCoursesUseCase
import com.example.domain.usecase.ToggleBookmarkUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetCoursesUseCase(get(), get()) }
    factory { ToggleBookmarkUseCase(get()) }
}
