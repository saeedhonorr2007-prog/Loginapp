package com.varud.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.varud.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text?.toString()?.trim().orEmpty()
            val password = binding.etPassword.text?.toString().orEmpty()

            // پاک کردن خطاهای قبلی
            binding.tvError.visibility = View.GONE
            binding.tilUsername.error = null
            binding.tilPassword.error = null

            when {
                username.isEmpty() ->
                    binding.tilUsername.error = getString(R.string.error_empty_username)

                password.isEmpty() ->
                    binding.tilPassword.error = getString(R.string.error_empty_password)

                username == "mobile" && password == "1234" -> {
                    val intent = Intent(this, WelcomeActivity::class.java)
                    intent.putExtra(WelcomeActivity.EXTRA_USERNAME, username)
                    startActivity(intent)
                }

                else -> {
                    binding.tvError.text = getString(R.string.error_wrong_credentials)
                    binding.tvError.visibility = View.VISIBLE
                }
            }
        }
    }
}
