package com.example.firebaseauth.features.login

import android.content.Intent
import com.example.core.BaseActivity
import com.example.core.BaseEvent
import com.example.firebaseauth.R
import com.example.firebaseauth.databinding.ActivityLoginBinding
import com.example.firebaseauth.features.profile.ProfileActivity
import com.example.firebaseauth.features.register.RegisterActivity

class LoginActivity :
    BaseActivity<ActivityLoginBinding, LoginEvents, LoginData, LoginViewModel>(
        LoginViewModel::class,
        R.layout.activity_login
    ) {

    override fun eventUpdated(event: BaseEvent) {
        when (event) {
            is LoginEvents.OnRegisterClicked -> {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
            is LoginEvents.OnLoginClicked -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}