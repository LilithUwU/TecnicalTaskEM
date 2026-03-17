package com.example.tecnicaltaskem.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tecnicaltaskem.data.local.dao.CourseDao
import com.example.tecnicaltaskem.data.local.entity.Course

@Database(entities = [Course::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
}