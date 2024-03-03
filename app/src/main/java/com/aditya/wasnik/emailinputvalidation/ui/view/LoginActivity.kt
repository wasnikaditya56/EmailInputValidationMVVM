package com.aditya.wasnik.emailinputvalidation.ui.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.aditya.wasnik.emailinputvalidation.databinding.ActivityLoginBinding
import com.aditya.wasnik.emailinputvalidation.model.LoginBody
import com.aditya.wasnik.emailinputvalidation.ui.viewmodel.LoginViewModel
import com.aditya.wasnik.emailinputvalidation.ui.viewmodel.ViewModelFactory

class LoginActivity: AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel : LoginViewModel by viewModels {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            val email = binding.editText.text.toString()
            val password = binding.edtEmail.text.toString()
            when {
                email.isEmpty() -> {
                    binding.editText.error = "Enter email please"
                }
                password.isEmpty() -> {
                    binding.edtEmail.error = "Enter valid password"
                }
                else -> {
                    val loginBody = LoginBody(email, password)
                    loginViewModel.login(loginBody)
                }
            }
        }
    }
}