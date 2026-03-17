package com.example.tecnicaltaskem.data.repository

import com.example.tecnicaltaskem.data.local.dao.CourseDao
import com.example.tecnicaltaskem.data.local.entity.Course
import kotlinx.coroutines.flow.Flow


interface IRepository {
    fun getCourses(): Flow<List<Course>>
    suspend fun delete(id: Int)
    suspend fun insert(course: Course)
    suspend fun getCourseIds(): List<Int>
}

class Repository (private val courseDao: CourseDao) : IRepository {
    override  fun getCourses(): Flow<List<Course>> {
        return courseDao.getAll()
    }
    override suspend fun delete(id: Int) {
        courseDao.delete(id)
    }
    override suspend fun insert(course: Course) {
        courseDao.insert(course)
    }

    override suspend fun getCourseIds(): List<Int> {
       return courseDao.getCourseIds()
    }



}