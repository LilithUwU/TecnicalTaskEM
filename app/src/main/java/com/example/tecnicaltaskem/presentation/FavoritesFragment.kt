package com.example.tecnicaltaskem.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tecnicaltaskem.R
import com.example.tecnicaltaskem.databinding.FragmentFavoritesBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavoritesFragment : Fragment() {
    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeFragmentViewModel by viewModel(
        ownerProducer = { requireActivity() }
    )

    private lateinit var adapter: CourseAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        adapter = CourseAdapter(
            courses = emptyList(),
            onBookmarkClick = { course ->
                viewModel.toggleBookmark(course)
            },
            onCourseClick = { course ->
                Log.d("BaseApp", "Course clicked: ${course.id}")
                viewModel.selectCourse(course)
                Log.d("BaseApp", "After selectCourse: ${viewModel.selectedCourse.value?.id}")
                findNavController().navigate(R.id.navigation_details)
            }
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }
    private fun observeViewModel() {
        viewModel.getSavedCourses()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.savedCourses.collect { courses ->
                adapter.updateCourses(courses)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
