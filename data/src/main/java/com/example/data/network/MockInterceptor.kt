package com.example.data.network

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class MockInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val uri = chain.request().url.toString()
        val responseString = when {
            uri.contains("courses") -> """
                [
                    {
                        "id": 100,
                        "title": "Java-разработчик с нуля",
                        "text": "Освойте backend-разработку и программирование на Java, фреймворки Spring и Maven, работу с базами данных и API. Создайте свой собственный проект, собрав портфолио и став востребованным специалистом для любой IT компании.",
                        "price": 999.0,
                        "rate": 4.9,
                        "startDate": 1716336000000,
                        "hasLike": false,
                        "publishDate": 1684713600000,
                        "imgLink": "https://miro.medium.com/v2/resize:fit:4800/format:webp/1*O00ZHwDkY3yrtT80WBhyGQ.jpeg"
                    },
                    {
                        "id": 101,
                        "title": "3D-дженералист",
                        "text": "Освой профессию 3D-дженералиста и стань универсальным специалистом, который умеет создавать 3D-модели, текстуры и анимации, а также может строить карьеру в геймдеве, кино, рекламе или дизайне.",
                        "price": 12000.0,
                        "rate": 3.9,
                        "startDate": 1725926400000,
                        "hasLike": false,
                        "publishDate": 1705708800000,
                        "imgLink": "https://www.ikreate.com.np/assets/uploads/services/2025-07-01_hGcqJoI3SRj0MnYAwXui7BeDbzmF4NQH2.jpg"
                    },
                    {
                        "id": 102,
                        "title": "Python Advanced. Для продвинутых",
                        "text": "Вы узнаете, как разрабатывать гибкие и высокопроизводительные серверные приложения на языке Kotlin. Преподаватели на вебинарах покажут пример того, как разрабатывается проект маркетплейса: от идеи и постановки задачи – до конечного решения",
                        "price": 1299.0,
                        "rate": 4.3,
                        "startDate": 1728691200000,
                        "hasLike": true,
                        "publishDate": 1723248000000,
                        "imgLink": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEXNKTRoWagYMhO5lrdHKn0_IBh67ltFz2iPtWTFTOiC8LOj8q"
                    },
                    {
                        "id": 103,
                        "title": "Системный аналитик",
                        "text": "Освоите навыки системной аналитики с нуля за 9 месяцев. Будет очень много практики на реальных проектах, чтобы вы могли сразу стартовать в IT.",
                        "price": 1199.0,
                        "rate": 4.5,
                        "startDate": 1713139200000,
                        "hasLike": false,
                        "publishDate": 1705104000000,
                        "imgLink": "https://img.freepik.com/premium-photo/online-exam-test-3d-illustration-3d-online-exam-course-concept-with-books-computer_554821-1742.jpg"
                    },
                    {
                        "id": 104,
                        "title": "Аналитик данных",
                        "text": "В этом уроке вы узнаете, кто такой аналитик данных и какие задачи он решает. А главное — мы расскажем, чему вы научитесь по завершении программы обучения профессии «Аналитик данных».",
                        "price": 899.0,
                        "rate": 4.7,
                        "startDate": 1718841600000,
                        "hasLike": false,
                        "publishDate": 1710201600000,
                        "imgLink": "https://img.freepik.com/free-vector/data-concept-illustration-idea-collecting-analysing-using_613284-1574.jpg?semt=ais_hybrid&w=740&q=80"
                    }
                ]
            """.trimIndent()
            else -> "[]"
        }

        return Response.Builder()
            .code(200)
            .message("OK")
            .request(chain.request())
            .protocol(Protocol.HTTP_1_1)
            .body(responseString.toResponseBody("application/json".toMediaTypeOrNull()))
            .addHeader("content-type", "application/json")
            .build()
    }
}
