package com.example.tecnicaltaskem.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

val courses = listOf(
    Course(
        id = 100,
        title = "Java-разработчик с нуля",
        text = "Освойте backend-разработку и программирование на Java, фреймворки Spring и Maven, работу с базами данных и API. Создайте свой собственный проект, собрав портфолио и став востребованным специалистом для любой IT компании.",
        price = 999f,
        rate = 4.9f,
        startDate = 1716336000000L,
        hasLike = false,
        publishDate = 1684713600000L
    ),
    Course(
        id = 101,
        title = "3D-дженералист",
        text = "Освой профессию 3D-дженералиста и стань универсальным специалистом, который умеет создавать 3D-модели, текстуры и анимации, а также может строить карьеру в геймдеве, кино, рекламе или дизайне.",
        price = 12000f,
        rate = 3.9f,
        startDate = 1725926400000L,
        hasLike = false,
        publishDate = 1705708800000L
    ),
    Course(
        id = 102,
        title = "Python Advanced. Для продвинутых",
        text = "Вы узнаете, как разрабатывать гибкие и высокопроизводительные серверные приложения на языке Kotlin. Преподаватели на вебинарах покажут пример того, как разрабатывается проект маркетплейса: от идеи и постановки задачи – до конечного решения",
        price = 1299f,
        rate = 4.3f,
        startDate = 1728691200000L,
        hasLike = true,
        publishDate = 1723248000000L
    ),
    Course(
        id = 103,
        title = "Системный аналитик",
        text = "Освоите навыки системной аналитики с нуля за 9 месяцев. Будет очень много практики на реальных проектах, чтобы вы могли сразу стартовать в IT.",
        price = 1199f,
        rate = 4.5f,
        startDate = 1713139200000L,
        hasLike = false,
        publishDate = 1705104000000L
    ),
    Course(
        id = 104,
        title = "Аналитик данных",
        text = "В этом уроке вы узнаете, кто такой аналитик данных и какие задачи он решает. А главное — мы расскажем, чему вы научитесь по завершении программы обучения профессии «Аналитик данных».",
        price = 899f,
        rate = 4.7f,
        startDate = 1718841600000L,
        hasLike = false,
        publishDate = 1710201600000L
    )
)


class HomeFragmentViewModel: ViewModel() {
    fun getCourses() : StateFlow<List<Course>> {
        return MutableStateFlow(courses)
    }

    fun sortByPublishedDate() : StateFlow<List<Course>>{
        return MutableStateFlow(courses.sortedBy { it.publishDate })
    }
}
