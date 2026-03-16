package com.example.tecnicaltaskem.presentation

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
    private val repository: IRepository by inject(IRepository::class.java)


    var selectedCourse: Course? = null

    private val _savedCourses = MutableStateFlow<List<Course>>(emptyList())
    val savedCourses: StateFlow<List<Course>> = _savedCourses

    fun selectCourse(course: Course) {
        selectedCourse = course
    }

    fun getMockCourses() : StateFlow<List<Course>> {
        return MutableStateFlow(mockCourses)
    }

    fun sortByPublishedDate() : StateFlow<List<Course>>{
        return MutableStateFlow(mockCourses.sortedBy { it.publishDate })
    }

    fun saveCourse() {
        viewModelScope.launch {
            if (selectedCourse != null) {
                repository.insert(selectedCourse!!)
            }
        }
    }
}
