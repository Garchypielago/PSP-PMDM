package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalproject.databinding.ActivityLoginBinding
import com.example.finalproject.utils.constants
import com.example.finalproject.viewModels.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val myLoginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.loginMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding) {

            loginBtn.setOnClickListener {
                myLoginViewModel.login(loginEmail.text.toString(), loginPass.text.toString())
            }

            myLoginViewModel.data.observe(this@LoginActivity) { response ->
                    val access = response.accessToken.trim()
                    val refresh = response.refreshToken.trim()

                    if (access.isNotEmpty() && refresh.isNotEmpty()) {
                        constants.ACCESS_TOKEN = "Bearer $access"
                        constants.REFRESH_TOKEN = "Bearer $refresh"
                        constants.USERNAME = loginEmail.text.toString().split("@")[0]

                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    } else {
                        Toast.makeText(this@LoginActivity, "Access unauthorized", Toast.LENGTH_SHORT).show()

                    }
                }

        }
    }
}