package com.example.tecnicaltaskem

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Course
import com.example.domain.usecase.GetCoursesUseCase
import com.example.domain.usecase.ToggleBookmarkUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AppViewModel(
    private val getCoursesUseCase: GetCoursesUseCase,
    private val toggleBookmarkUseCase: ToggleBookmarkUseCase
) : ViewModel() {

    private val _selectedCourse = MutableStateFlow<Course?>(null)
    val selectedCourse: StateFlow<Course?> = _selectedCourse.asStateFlow()

    val courses: StateFlow<List<Course>> = getCoursesUseCase()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val savedCourses: StateFlow<List<Course>> = courses
        .map { allCourses -> allCourses.filter { it.hasLike } }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun selectCourse(course: Course) {
        _selectedCourse.value = course
    }

    fun toggleBookmark(course: Course) {
        viewModelScope.launch {
            toggleBookmarkUseCase(course)
            // Update selected course if it's the one being bookmarked
            if (_selectedCourse.value?.id == course.id) {
                _selectedCourse.value = _selectedCourse.value?.copy(hasLike = !course.hasLike)
            }
        }
    }

    fun sortByPublishedDate() = courses.map { it.sortedByDescending { course -> course.publishDate } }

    fun saveCourse() {
        _selectedCourse.value?.let { toggleBookmark(it) }
    }
}