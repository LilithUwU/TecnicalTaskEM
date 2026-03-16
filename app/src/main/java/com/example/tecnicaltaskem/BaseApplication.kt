package com.example.tecnicaltaskem

import android.app.Application
import com.example.tecnicaltaskem.data.AppDatabase
import com.example.tecnicaltaskem.data.repository.Repository
import kotlin.getValue

class BaseApplication : Application(){
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { Repository(database.courseDao()) }
}
