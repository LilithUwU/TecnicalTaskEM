package com.example.domain.usecase

import com.example.domain.model.Course
import com.example.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf

class GetCoursesUseCase(
    private val repository: CourseRepository,
    private val mockCourses: List<Course>
) {
    operator fun invoke(): Flow<List<Course>> {
        return repository.getSavedCourses().combine(flowOf(mockCourses)) { saved, mocks ->
            mocks.map { mock ->
                mock.copy(hasLike = saved.any { it.id == mock.id })
            }
        }
    }
}
