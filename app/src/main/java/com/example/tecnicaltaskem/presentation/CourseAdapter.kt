package com.example.tecnicaltaskem.presentation

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnicaltaskem.R
import com.example.tecnicaltaskem.data.local.entity.Course
import com.example.tecnicaltaskem.databinding.CourseViewBinding

class CourseAdapter(
    private var courses: List<Course>,
    private val onCourseClick: (Course) -> Unit,
    private val onBookmarkClick: (Course) -> Unit
) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    inner class CourseViewHolder(private val binding: CourseViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(course: Course) {
            binding.textHeadline.text = course.title
            binding.textContent.text = course.text
            binding.textRating.text = course.rate.toString()
            binding.textDate.text = getFormattedDate(course.startDate)
            binding.textPrice.text = binding.root.context.getString(R.string.formatted_rub, course.price)
            binding.buttonBookmark.setImageDrawable(getUpdateIcon(course))
            
            binding.buttonMoreInfo.setOnClickListener {
                onCourseClick(course)
            }

            loadImageWithPlaceholder(binding.imageView, course.imgLink)
            
            binding.buttonBookmark.setOnClickListener {
                onBookmarkClick(course)
            }
        }

        private fun getUpdateIcon(course: Course): Drawable? = if (course.hasLike) {
            binding.root.context.getDrawable(R.drawable.navigation_bookmark_filled)
        } else {
            binding.root.context.getDrawable(R.drawable.navigation_bookmark)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = CourseViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(courses[position])
    }

    override fun getItemCount(): Int = courses.size

    fun updateCourses(newCourses: List<Course>) {
        courses = newCourses
        notifyDataSetChanged()
    }
}
