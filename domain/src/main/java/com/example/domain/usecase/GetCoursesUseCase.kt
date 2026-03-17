package com.example.domain.usecase

import com.example.domain.model.Course
import com.example.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow

class GetCoursesUseCase(
    private val repository: CourseRepository
) {
    operator fun invoke(): Flow<List<Course>> = repository.getSavedCourses()
}
