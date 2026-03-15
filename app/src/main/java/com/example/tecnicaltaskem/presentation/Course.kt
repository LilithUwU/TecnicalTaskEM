package com.example.tecnicaltaskem.presentation

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

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
) {

    fun getFormattedDate(date: Long): String {
        val dateValue = Date(date)
        val format = SimpleDateFormat("dd MMMM yyyy", Locale.forLanguageTag("ru"))
        return format.format(dateValue)
    }
}
