package com.example.firebaseauth.features.register

import android.app.Application
import com.example.core.BaseViewModel
import com.example.firebaseauth.features.UserInfo
import com.google.firebase.database.*

class RegisterViewModel(
    application: Application,
    data: RegisterData
) : BaseViewModel<RegisterData, RegisterEvents>(application, data) {

    private var dbReference: DatabaseReference = FirebaseDatabase.getInstance().reference

    val onRegisterClickListener = {
        validateRegistration()
    }

    private fun validateRegistration() {
        if (data.email.value.equals("") || data.password.value.equals("") || data.username.value.equals(
                ""
            ) || data.bio
                .value.equals("")
        ) {
            data.setErrorMessage(MANDATORY_FIELDS)
        } else {
            data.setErrorMessage("")
            addToDataBase(
                data.email.value?.replace(".", ""),
                data.password.value,
                data.username.value,
                data.bio.value
            )
        }
    }

    private fun addToDataBase(email: String?, password: String?, username: String?, bio: String?) {
        val userInfo = UserInfo(email, password, username, bio)

        dbReference
            .orderByChild(EMAIL)
            .equalTo(email.toString())
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.value != null) {
                        data.setErrorMessage(EMAIL_ALREADY_EXIST)
                    } else {
                        dbReference.child(email.toString()).setValue(userInfo)
                        updateEvent(RegisterEvents.OnRegisterClicked)
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    data.setErrorMessage(databaseError.message)
                }
            })
    }

    companion object {
        private const val MANDATORY_FIELDS = "Please enter all the fields"
        private const val EMAIL_ALREADY_EXIST = "User already exist"
        private const val EMAIL = "email"
    }
}