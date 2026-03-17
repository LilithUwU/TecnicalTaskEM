package com.example.tecnicaltaskem.presentation.helpers

import android.R
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

fun loadImageWithPlaceholder(imageView: ImageView, imageUrl: String) {
    Glide.with(imageView.context)
        .load(imageUrl)
        .placeholder(R.drawable.ic_dialog_info)
        .error(R.drawable.ic_dialog_alert)
        .into(imageView)
}

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