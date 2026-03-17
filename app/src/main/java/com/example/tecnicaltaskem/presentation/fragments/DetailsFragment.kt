package com.example.tecnicaltaskem.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnicaltaskem.databinding.FragmentDetailsBinding
import com.example.tecnicaltaskem.AppViewModel
import com.example.tecnicaltaskem.presentation.helpers.getFormattedDate
import com.example.tecnicaltaskem.presentation.helpers.loadImageWithPlaceholder
import com.example.tecnicaltaskem.presentation.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by viewModel(
        ownerProducer = { requireActivity() }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).shouldApplyPadding = false

        val course = viewModel.selectedCourse.value
        if (course != null) {
            binding.textHeadline.text = course.title
            binding.textDescription.text = course.text
            binding.textRating.text = course.rate.toString()
            binding.textDate.text = getFormattedDate(course.startDate)
            loadImageWithPlaceholder(binding.imageView, course.imgLink)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as MainActivity).shouldApplyPadding = true
        _binding = null
    }
}