package com.example.tecnicaltaskem.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.example.tecnicaltaskem.presentation.main.MainActivity
import com.example.tecnicaltaskem.R
import com.example.tecnicaltaskem.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.imageButtonVK.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, getString(R.string.link_vk).trim().toUri()))
        }

        binding.imageButtonOK.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, getString(R.string.link_ok).trim().toUri()))
        }
//
//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.isLoginButtonEnabled.collect { isEnabled ->
//                    binding.buttonLogin.isEnabled = isEnabled
//                }
//            }
//        }
//
//        binding.editTextEmailAddress.addTextChangedListener {
//            viewModel.onEmailChanged(it.toString())
//        }
//        binding.editTextPassword.addTextChangedListener {
//            viewModel.onPasswordChanged(it.toString())
//        }
    }
}