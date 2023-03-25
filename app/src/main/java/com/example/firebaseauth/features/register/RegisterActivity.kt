package com.example.firebaseauth.features.register

import com.example.core.BaseActivity
import com.example.core.BaseEvent
import com.example.firebaseauth.R
import com.example.firebaseauth.databinding.ActivityRegisterBinding

class RegisterActivity :
    BaseActivity<ActivityRegisterBinding, RegisterEvents, RegisterData, RegisterViewModel>(
        RegisterViewModel::class,
        R.layout.activity_register
    ) {

    override fun eventUpdated(event: BaseEvent) {
        when (event) {
            is RegisterEvents.OnRegisterClicked -> {
                finish()
            }
        }
    }
}