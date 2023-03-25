package com.example.firebaseauth.di

import com.example.firebaseauth.features.login.LoginData
import com.example.firebaseauth.features.login.LoginViewModel
import com.example.firebaseauth.features.profile.ProfileData
import com.example.firebaseauth.features.profile.ProfileViewModel
import com.example.firebaseauth.features.register.RegisterData
import com.example.firebaseauth.features.register.RegisterViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel {
        ProfileViewModel(
            application = androidApplication(),
            data = ProfileData(),
            weatherUseCase = get()
        )
    }

    viewModel {
        LoginViewModel(
            application = androidApplication(),
            data = LoginData()
        )
    }

    viewModel {
        RegisterViewModel(
            application = androidApplication(),
            data = RegisterData()
        )
    }
}