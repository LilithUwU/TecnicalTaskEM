package com.example.domain.usecase

import com.example.domain.model.Course
import com.example.domain.repository.CourseRepository

class ToggleBookmarkUseCase(private val repository: CourseRepository) {
    suspend operator fun invoke(course: Course) {
        repository.toggleBookmark(course)
    }
}
