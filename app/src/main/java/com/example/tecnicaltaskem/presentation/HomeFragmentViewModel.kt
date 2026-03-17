package com.example.tecnicaltaskem.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnicaltaskem.data.local.entity.Course
import com.example.tecnicaltaskem.data.repository.IRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class HomeFragmentViewModel(
    private val repository: IRepository
) : ViewModel() {
    private val _selectedCourse = MutableStateFlow<Course?>(null)
    val selectedCourse: StateFlow<Course?> = _selectedCourse.asStateFlow()

    fun selectCourse(course: Course) {
        _selectedCourse.value = course
    }

    private val _courses = MutableStateFlow<List<Course>>(mockCourses)
    val courses: StateFlow<List<Course>> = _courses.asStateFlow()

    private val _savedCourses = MutableStateFlow<List<Course>>(emptyList())
    val savedCourses: StateFlow<List<Course>> = _savedCourses

    fun getMockCourses(): StateFlow<List<Course>> {
        return courses
    }

    fun sortByPublishedDate(): StateFlow<List<Course>> {
        return MutableStateFlow(_courses.value.sortedBy { it.publishDate })
    }

    fun toggleBookmark(course: Course) {
        viewModelScope.launch {
            val isBookmarked = repository.getCourseIds().contains(course.id)
            if (isBookmarked) {
                repository.delete(course.id)
            } else {
                try {
                    repository.insert(course)
                    repository.setLike(course.id, true)
                    Log.d("BaseApp", "Course inserted: ${course.id}")
                } catch (e: Exception) {
                    Log.e("BaseApp", "Insert failed: ${e.message}")
                }
            }
            
            // Update the state flow list to trigger UI update
            val updatedIsBookmarked = !isBookmarked
            _courses.value = _courses.value.map {
                if (it.id == course.id) {
                    val updatedCourse = it.copy(hasLike = updatedIsBookmarked)
                    // If this is the selected course, keep it in sync
                    if (_selectedCourse.value?.id == course.id) {
                        _selectedCourse.value = updatedCourse
                    }
                    updatedCourse
                } else it
            }
        }
    }

    fun saveCourse() {
        _selectedCourse.value?.let { toggleBookmark(it) }
    }


    fun getSavedCourses() {
        viewModelScope.launch {
            repository.getCourses().collect { courses ->
                _savedCourses.value = courses
            }
        }
    }
}
