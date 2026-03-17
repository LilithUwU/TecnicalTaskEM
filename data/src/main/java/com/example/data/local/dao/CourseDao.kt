package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.entity.CourseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
    @Query("SELECT * FROM courses")
    fun getAll(): Flow<List<CourseEntity>>

    @Query("DELETE FROM courses WHERE id = :id")
    suspend fun delete(id: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(course: CourseEntity): Long

    @Query("SELECT id FROM courses")
    suspend fun getCourseIds(): List<Int>

    @Query("UPDATE courses SET hasLike = :like WHERE id = :id")
    suspend fun setLike(id: Int, like: Boolean) : Int

    @Query("SELECT * FROM courses WHERE id = :id")
    suspend fun getCourseById(id: Int): CourseEntity?
}
