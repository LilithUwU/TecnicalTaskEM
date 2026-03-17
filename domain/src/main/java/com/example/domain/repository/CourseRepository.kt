package com.example.domain.repository

import com.example.domain.model.Course
import kotlinx.coroutines.flow.Flow

interface CourseRepository {
    fun getSavedCourses(): Flow<List<Course>>
    suspend fun toggleBookmark(course: Course)
    suspend fun getCourseIds(): List<Int>
    suspend fun getCourseById(id: Int): Course?
}
