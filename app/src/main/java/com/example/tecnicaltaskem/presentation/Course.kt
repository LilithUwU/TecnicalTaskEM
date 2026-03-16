package com.example.tecnicaltaskem.presentation

data class Course(
    val id: Int,
    val title: String,
    val text: String,
    val price: Float,
    val rate: Float,
    val startDate: Long,
    val hasLike: Boolean,
    val publishDate: Long,
    val imgLink: String
)
