package com.example.tecnicaltaskem.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnicaltaskem.data.local.entity.Course
import com.example.tecnicaltaskem.data.repository.IRepository
import com.example.tecnicaltaskem.data.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class HomeFragmentViewModel: ViewModel() {


    var selectedCourse: Course? = null

    fun selectCourse(course: Course) {
        selectedCourse = course
    }


    private val repository: IRepository by inject(IRepository::class.java)


    private val _savedCourses = MutableStateFlow<List<Course>>(emptyList())
    val savedCourses: StateFlow<List<Course>> = _savedCourses




    fun getMockCourses() : StateFlow<List<Course>> {
        return MutableStateFlow(mockCourses)
    }

    fun sortByPublishedDate() : StateFlow<List<Course>>{
        return MutableStateFlow(mockCourses.sortedBy { it.publishDate })
    }

    fun saveCourse() {
        viewModelScope.launch {
            Log.d("Database", "Saving course... ${selectedCourse}")
            selectedCourse?.let {
                try {
                    repository.insert(it)
                    Log.d("Database", "Course inserted: ${it.id}")
                } catch (e: Exception) {
                    Log.e("Database", "Insert failed: ${e.message}")
                }
            }
        }
    }
}
