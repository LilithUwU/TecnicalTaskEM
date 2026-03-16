package com.example.tecnicaltaskem.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tecnicaltaskem.data.local.dao.Dao
import com.example.tecnicaltaskem.data.local.entity.Course

@Database(entities = [Course::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun courseDao(): Dao
}