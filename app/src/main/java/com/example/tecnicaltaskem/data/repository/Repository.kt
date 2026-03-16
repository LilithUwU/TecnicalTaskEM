package com.example.tecnicaltaskem.data.repository

import com.example.tecnicaltaskem.data.local.dao.Dao
import com.example.tecnicaltaskem.data.local.entity.Course
import kotlinx.coroutines.flow.Flow

interface IRepository {
    suspend fun getCourses(): Flow<List<Course>>
    suspend fun delete(id: Int)
    suspend fun insert(course: Course)
}

class Repository (private val dao: Dao) : IRepository {
    override suspend fun getCourses(): Flow<List<Course>> {
        return dao.getAll()
    }
    override suspend fun delete(id: Int) {
        dao.delete(id)
    }
    override suspend fun insert(course: Course) {
        dao.insert(course)
    }
}
