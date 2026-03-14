package com.example.tecnicaltaskem

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.example.tecnicaltaskem.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.imageButtonVK.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, getString(R.string.link_vk).trim().toUri()))
        }

        binding.imageButtonOK.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, getString(R.string.link_ok).trim().toUri()))
        }
    }
}