package com.example.tecnicaltaskem.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tecnicaltaskem.data.local.entity.Course
import kotlinx.coroutines.flow.Flow


@Dao
interface CourseDao {
    @Query("SELECT * FROM courses")
    fun getAll(): Flow<List<Course>>

    @Query("DELETE FROM courses WHERE id = :id")
    suspend fun delete(id: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(course: Course): Long

    @Query("SELECT id FROM courses")
    suspend fun getCourseIds(): List<Int>

    @Query("UPDATE courses SET hasLike = :like WHERE id = :id")
    suspend fun setLike(id: Int, like: Boolean) : Int

    @Query("SELECT * FROM courses WHERE id = :id")
    suspend fun getCourseById(id: Int): Course?
}
