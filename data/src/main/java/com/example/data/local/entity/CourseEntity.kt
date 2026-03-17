package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses")
data class CourseEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val text: String,
    val price: Float,
    val rate: Float,
    val startDate: Long,
    val hasLike: Boolean,
    val publishDate: Long,
    val imgLink: String
)
