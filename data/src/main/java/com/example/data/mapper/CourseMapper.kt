package com.example.data.mapper

import com.example.data.local.entity.CourseEntity
import com.example.domain.model.Course

fun CourseEntity.toDomain(): Course {
    return Course(
        id = id,
        title = title,
        text = text,
        price = price,
        rate = rate,
        startDate = startDate,
        hasLike = hasLike,
        publishDate = publishDate,
        imgLink = imgLink
    )
}

fun Course.toEntity(): CourseEntity {
    return CourseEntity(
        id = id,
        title = title,
        text = text,
        price = price,
        rate = rate,
        startDate = startDate,
        hasLike = hasLike,
        publishDate = publishDate,
        imgLink = imgLink
    )
}
