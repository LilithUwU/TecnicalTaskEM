package com.example.data.network

import com.example.data.local.entity.CourseEntity
import retrofit2.http.GET

interface CourseApi {
    @GET("courses")
    suspend fun getCourses(): List<CourseEntity>
}
