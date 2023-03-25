package com.example.firebaseauth.features

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class UserInfo(
    val email: String? = "",
    val password: String? = "",
    val username: String? = "",
    val bio: String? = ""
) : Parcelable
