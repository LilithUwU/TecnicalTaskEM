package com.example.tecnicaltaskem.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tecnicaltaskem.data.local.entity.Course
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao{
    @Query("SELECT * FROM courses")
    fun getAll(): Flow<List<Course>>

    @Query("DELETE FROM courses WHERE id = :id")
    fun delete(id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(course: Course)
}