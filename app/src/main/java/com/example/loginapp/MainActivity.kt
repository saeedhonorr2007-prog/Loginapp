package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

/**
 * صفحه ورود (صفحه اول):
 * اگر نام کاربری و رمز عبور درست باشند، کاربر به صفحه دوم (WelcomeActivity) منتقل می‌شود
 * و در غیر این صورت پیام خطا نمایش داده می‌شود.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsername = findViewById<TextInputEditText>(R.id.etUsername)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)
        val tvError = findViewById<TextView>(R.id.tvError)

        btnLogin.setOnClickListener {
            // ارقام فارسی/عربی به ارقام انگلیسی تبدیل می‌شوند تا رمز با هر کیبوردی پذیرفته شود
            val username = normalizeDigits(etUsername.text?.toString()?.trim().orEmpty())
            val password = normalizeDigits(etPassword.text?.toString()?.trim().orEmpty())

            if (username == USERNAME && password == PASSWORD) {
                // ورود موفق: پنهان کردن خطا و رفتن به صفحه دوم
                tvError.visibility = View.GONE

                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra(WelcomeActivity.EXTRA_USERNAME, username)
                startActivity(intent)
                // MainActivity را finish نمی‌کنیم تا با «خروج» دوباره به صفحه ورود برگردید
            } else {
                // ورود ناموفق: نمایش پیام خطا
                tvError.text = getString(R.string.error_invalid_credentials)
                tvError.visibility = View.VISIBLE
            }
        }

        // با شروع تایپ مجدد، پیام خطا پنهان شود
        listOf(etUsername, etPassword).forEach { field ->
            field.addTextChangedListener(object : android.text.TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
                override fun onTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
                override fun afterTextChanged(s: android.text.Editable?) {
                    tvError.visibility = View.GONE
                }
            })
        }
    }

    /** تبدیل ارقام فارسی (۰-۹) و عربی (٠-٩) به ارقام انگلیسی (0-9) */
    private fun normalizeDigits(value: String): String = buildString {
        for (c in value) {
            when (c) {
                in '۰'..'۹' -> append('0' + (c - '۰'))
                in '٠'..'٩' -> append('0' + (c - '٠'))
                else -> append(c)
            }
        }
    }

    companion object {
        // مشخصات ورود پیش‌فرض — برای تغییر، فقط همین دو مقدار را ویرایش کنید
        private const val USERNAME = "mobile"
        private const val PASSWORD = "1234"
    }
}
