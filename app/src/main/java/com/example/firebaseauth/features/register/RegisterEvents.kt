package com.example.firebaseauth.features.register

import com.example.core.BaseEvent

sealed class RegisterEvents : BaseEvent {
    object OnRegisterClicked : RegisterEvents()
}