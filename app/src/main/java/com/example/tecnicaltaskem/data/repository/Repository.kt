package com.example.tecnicaltaskem.data.repository

import com.example.tecnicaltaskem.data.local.dao.Dao
import com.example.tecnicaltaskem.data.local.entity.Course
import kotlinx.coroutines.flow.Flow

class Repository(private val courseDao: Dao) {
    
    suspend fun getAllCourses(): Flow<List<Course>> {
        return courseDao.getAll()
    }

    suspend fun getLikedCourses(): Flow<List<Course>> {
        return courseDao.getCourses()
    }

    suspend fun insert(course: Course) {
        courseDao.insert(course)
    }

    suspend fun delete(id: Int) {
        courseDao.delete(id)
    }
}