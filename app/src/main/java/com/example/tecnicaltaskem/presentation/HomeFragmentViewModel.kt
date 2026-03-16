package com.example.tecnicaltaskem.presentation

import androidx.lifecycle.ViewModel
import com.example.tecnicaltaskem.data.local.entity.Course
import com.example.tecnicaltaskem.data.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeFragmentViewModel: ViewModel() {

    private val _selectedCourse = MutableStateFlow<Course?>(null)
    val selectedCourse: StateFlow<Course?> = _selectedCourse

    private val _savedCourses = MutableStateFlow<List<Course>>(emptyList())
    val savedCourses: StateFlow<List<Course>> = _savedCourses


    fun selectCourse(course: Course) {
        _selectedCourse.value = course
    }

    fun getMockCourses() : StateFlow<List<Course>> {
        return MutableStateFlow(mockCourses)
    }

    fun sortByPublishedDate() : StateFlow<List<Course>>{
        return MutableStateFlow(mockCourses.sortedBy { it.publishDate })
    }

    fun saveCourse(course: Course) {
//        repository.insert(course)
    }
}
