package com.example.firebaseauth.features.profile

import com.example.core.BaseActivity
import com.example.core.BaseEvent
import com.example.firebaseauth.R
import com.example.firebaseauth.databinding.ActivityProfileBinding

class ProfileActivity :
    BaseActivity<ActivityProfileBinding, ProfileEvents, ProfileData, ProfileViewModel>(
        ProfileViewModel::class,
        R.layout.activity_profile
    ) {

    override fun eventUpdated(event: BaseEvent) {
    }
}