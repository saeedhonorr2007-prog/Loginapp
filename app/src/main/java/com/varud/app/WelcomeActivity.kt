package com.varud.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.varud.app.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(EXTRA_USERNAME).orEmpty()
        binding.tvWelcome.text = getString(R.string.welcome_title, username)

        binding.btnLogout.setOnClickListener {
            // بازگشت به صفحه ورود
            finish()
        }
    }

    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }
}
