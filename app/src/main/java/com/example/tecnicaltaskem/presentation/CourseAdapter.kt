package com.example.tecnicaltaskem.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tecnicaltaskem.R
import com.example.tecnicaltaskem.databinding.CourseViewBinding

class CourseAdapter(
    private var courses: List<Course>,
    private val onCourseClick: (Course) -> Unit
) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    inner class CourseViewHolder(private val binding: CourseViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(course: Course) {
            binding.textHeadline.text = course.title
            binding.textContent.text = course.text
            binding.textRating.text = course.rate.toString()
            binding.textDate.text = course.getFormattedDate(course.startDate)
            binding.textPrice.text = binding.root.context.getString(R.string.formatted_rub, course.price)

            binding.buttonMoreInfo.setOnClickListener { onCourseClick(course) }

            loadImageWithPlaceholder(binding.imageView, course.imgLink)
        }
    }

    fun loadImageWithPlaceholder(imageView: ImageView, imageUrl: String) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .placeholder(android.R.drawable.ic_dialog_info)
            .error(android.R.drawable.ic_dialog_alert)
            .into(imageView)
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
