package com.example.tecnicaltaskem.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.tecnicaltaskem.R
import com.example.tecnicaltaskem.databinding.FragmentDetailsBinding
import com.example.tecnicaltaskem.databinding.FragmentFavoritesBinding
import kotlin.getValue


class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeFragmentViewModel by activityViewModels()


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
        val course = viewModel.selectedCourse.value!!
        binding.textHeadline.text = course.title
        binding.textDescription.text = course.text
        binding.textRating.text = course.rate.toString()
        binding.textDate.text = getFormattedDate(course.startDate)
        loadImageWithPlaceholder(binding.imageView, course.imgLink)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}