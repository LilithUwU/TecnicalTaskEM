package com.example.tecnicaltaskem.presentation

import android.widget.ImageView
import com.bumptech.glide.Glide

fun loadImageWithPlaceholder(imageView: ImageView, imageUrl: String) {
    Glide.with(imageView.context)
        .load(imageUrl)
        .placeholder(android.R.drawable.ic_dialog_info)
        .error(android.R.drawable.ic_dialog_alert)
        .into(imageView)
}