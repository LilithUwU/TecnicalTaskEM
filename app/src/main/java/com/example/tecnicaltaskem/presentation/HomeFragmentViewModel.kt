package com.example.tecnicaltaskem.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnicaltaskem.data.local.entity.Course
import com.example.tecnicaltaskem.data.repository.IRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class HomeFragmentViewModel(
    private val repository: IRepository
) : ViewModel() {
    var selectedCourse: Course? = null

    suspend fun isCourseSaved(id: Int): Boolean {
        return selectedCourse != null && repository.getCourseIds().contains(id)
    }

    fun selectCourse(course: Course) {
        selectedCourse = course
    }

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
            Log.d("BaseApp", "Saving course... ${selectedCourse}")
            selectedCourse?.let {
                try {
                    repository.insert(it)
                    Log.d("BaseApp", "Course inserted: ${it.id}")
                } catch (e: Exception) {
                    Log.e("BaseApp", "Insert failed: ${e.message}")
                }
            }
        }
    }
    fun delete()
    {

    }
}
