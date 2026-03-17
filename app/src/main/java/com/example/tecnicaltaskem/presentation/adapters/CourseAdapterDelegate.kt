package com.example.tecnicaltaskem.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Course
import com.example.tecnicaltaskem.R
import com.example.tecnicaltaskem.databinding.CourseViewBinding
import com.example.tecnicaltaskem.presentation.helpers.getFormattedDate
import com.example.tecnicaltaskem.presentation.helpers.loadImageWithPlaceholder

class CourseAdapterDelegate(
    private val onCourseClick: (Course) -> Unit,
    private val onBookmarkClick: (Course) -> Unit
) : AdapterDelegate {

    override fun isForViewType(item: Any): Boolean = item is Course

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = CourseViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).apply {
            (root.layoutParams as? ViewGroup.MarginLayoutParams)?.let {
                it.bottomMargin = root.context.resources.getDimensionPixelSize(R.dimen.item_spacing)
                root.layoutParams = it
            }
        }
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Any) {
        (holder as CourseViewHolder).bind(item as Course)
    }

    inner class CourseViewHolder(private val binding: CourseViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(course: Course) {
            binding.textHeadline.text = course.title
            binding.textContent.text = course.text
            binding.textRating.text = course.rate.toString()
            binding.textDate.text = getFormattedDate(course.startDate)
            binding.textPrice.text = binding.root.context.getString(R.string.formatted_rub, course.price.toInt().toString())

            val iconRes = if (course.hasLike) {
                R.drawable.navigation_bookmark_filled
            } else {
                R.drawable.navigation_bookmark
            }
            binding.buttonBookmark.setImageDrawable(AppCompatResources.getDrawable(binding.root.context, iconRes))

            binding.buttonMoreInfo.setOnClickListener {
                onCourseClick(course)
            }

            loadImageWithPlaceholder(binding.imageView, course.imgLink)

            binding.buttonBookmark.setOnClickListener {
                onBookmarkClick(course)
            }
        }
    }
}
