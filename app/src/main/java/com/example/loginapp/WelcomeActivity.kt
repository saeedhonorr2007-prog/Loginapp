package com.example.loginapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

/**
 * صفحه دوم: بعد از ورود موفق باز می‌شود و نام کاربری را نمایش می‌دهد.
 */
class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // خواندن نام کاربری از Intent که توسط MainActivity ارسال شده است
        val username = intent.getStringExtra(EXTRA_USERNAME).orEmpty()

        findViewById<TextView>(R.id.tvWelcomeUsername).text = username

        // دکمه خروج: بازگشت به صفحه ورود
        findViewById<MaterialButton>(R.id.btnLogout).setOnClickListener {
            finish()
        }
    }

    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }
}
