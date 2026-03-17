package com.example.data.repository

import com.example.data.local.dao.CourseDao
import com.example.data.mapper.toDomain
import com.example.data.mapper.toEntity
import com.example.domain.model.Course
import com.example.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CourseRepositoryImpl(private val courseDao: CourseDao) : CourseRepository {
    override fun getSavedCourses(): Flow<List<Course>> {
        return courseDao.getAll().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun toggleBookmark(course: Course) {
        val entity = courseDao.getCourseById(course.id)
        if (entity != null) {
            courseDao.delete(course.id)
        } else {
            courseDao.insert(course.toEntity().copy(hasLike = true))
        }
    }

    override suspend fun getCourseIds(): List<Int> {
        return courseDao.getCourseIds()
    }

    override suspend fun getCourseById(id: Int): Course? {
        return courseDao.getCourseById(id)?.toDomain()
    }
}
