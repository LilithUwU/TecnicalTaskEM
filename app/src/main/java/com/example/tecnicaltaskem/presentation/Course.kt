package com.example.tecnicaltaskem.presentation

import com.example.tecnicaltaskem.data.local.entity.Course

//
//data class Course(
//    val id: Int,
//    val title: String,
//    val text: String,
//    val price: Float,
//    val rate: Float,
//    val startDate: Long,
//    val hasLike: Boolean,
//    val publishDate: Long,
//    val imgLink: String
//)


val mockCourses = listOf(
    Course(
        id = 100,
        title = "Java-разработчик с нуля",
        text = "Освойте backend-разработку и программирование на Java, фреймворки Spring и Maven, работу с базами данных и API. Создайте свой собственный проект, собрав портфолио и став востребованным специалистом для любой IT компании.",
        price = 999f,
        rate = 4.9f,
        startDate = 1716336000000L,
        hasLike = false,
        publishDate = 1684713600000L,
        imgLink = "https://miro.medium.com/v2/resize:fit:4800/format:webp/1*O00ZHwDkY3yrtT80WBhyGQ.jpeg"
    ),
    Course(
        id = 101,
        title = "3D-дженералист",
        text = "Освой профессию 3D-дженералиста и стань универсальным специалистом, который умеет создавать 3D-модели, текстуры и анимации, а также может строить карьеру в геймдеве, кино, рекламе или дизайне.",
        price = 12000f,
        rate = 3.9f,
        startDate = 1725926400000L,
        hasLike = false,
        publishDate = 1705708800000L,
        imgLink = "https://www.ikreate.com.np/assets/uploads/services/2025-07-01_hGcqJoI3SRj0MnYAwXui7BeDbzmF4NQH2.jpg"
    ),
    Course(
        id = 102,
        title = "Python Advanced. Для продвинутых",
        text = "Вы узнаете, как разрабатывать гибкие и высокопроизводительные серверные приложения на языке Kotlin. Преподаватели на вебинарах покажут пример того, как разрабатывается проект маркетплейса: от идеи и постановки задачи – до конечного решения",
        price = 1299f,
        rate = 4.3f,
        startDate = 1728691200000L,
        hasLike = true,
        publishDate = 1723248000000L,
        imgLink = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEXNKTRoWagYMhO5lrdHKn0_IBh67ltFz2iPtWTFTOiC8LOj8q"
    ),
    Course(
        id = 103,
        title = "Системный аналитик",
        text = "Освоите навыки системной аналитики с нуля за 9 месяцев. Будет очень много практики на реальных проектах, чтобы вы могли сразу стартовать в IT.",
        price = 1199f,
        rate = 4.5f,
        startDate = 1713139200000L,
        hasLike = false,
        publishDate = 1705104000000L,
        imgLink = "https://img.freepik.com/premium-photo/online-exam-test-3d-illustration-3d-online-exam-course-concept-with-books-computer_554821-1742.jpg"
    ),
    Course(
        id = 104,
        title = "Аналитик данных",
        text = "В этом уроке вы узнаете, кто такой аналитик данных и какие задачи он решает. А главное — мы расскажем, чему вы научитесь по завершении программы обучения профессии «Аналитик данных».",
        price = 899f,
        rate = 4.7f,
        startDate = 1718841600000L,
        hasLike = false,
        publishDate = 1710201600000L,
        imgLink = "https://img.freepik.com/free-vector/data-concept-illustration-idea-collecting-analysing-using_613284-1574.jpg?semt=ais_hybrid&w=740&q=80"
    )
)