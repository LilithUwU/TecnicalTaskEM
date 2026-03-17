package com.example.tecnicaltaskem

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tecnicaltaskem.databinding.ActivityMainBinding
import com.example.tecnicaltaskem.presentation.HomeFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: HomeFragmentViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.navigation_details) {
                binding.topAppBar.visibility = View.VISIBLE
                binding.bottomNavigation.visibility = View.GONE
            } else {
                binding.topAppBar.visibility = View.GONE
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }

        binding.btnBack.setOnClickListener {
            navController.popBackStack()
        }
        binding.btnBookmark.setOnClickListener {
            Log.d("Database", "Button clicked!")

            viewModel.saveCourse()
            Toast.makeText(this, "Bookmark", Toast.LENGTH_SHORT).show()
        }
    }
}
