package com.example.firebaseauth.features.login

import com.example.core.BaseEvent
import com.example.firebaseauth.features.UserInfo

sealed class LoginEvents : BaseEvent {
    object OnRegisterClicked : LoginEvents()
    object OnLoginClicked : LoginEvents()
}