package com.example.tecnicaltaskem.presentation

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
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
        val ruLocale = Locale.forLanguageTag("ru")
        val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", ruLocale)
        val localDate = Instant.ofEpochMilli(date)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()

        val formatted = localDate.format(formatter)
        return formatted.split(" ").joinToString(" ") { word ->
            word.replaceFirstChar { if (it.isLowerCase()) it.titlecase(ruLocale) else it.toString() }
        }
    }
}
