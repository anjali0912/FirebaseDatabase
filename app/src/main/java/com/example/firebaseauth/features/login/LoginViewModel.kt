package com.example.firebaseauth.features.login

import android.app.Application
import com.example.core.BaseViewModel
import com.example.firebaseauth.User
import com.example.firebaseauth.features.UserInfo
import com.google.firebase.database.*

class LoginViewModel(
    application: Application, data: LoginData
) : BaseViewModel<LoginData, LoginEvents>(application, data) {

    private var dbReference: DatabaseReference = FirebaseDatabase.getInstance().reference

    val onRegisterClickListener = {
        updateEvent(LoginEvents.OnRegisterClicked)
    }

    val onLoginClickListener = {
        validateLogin()
    }

    private fun validateLogin() {
        if (data.email.value.equals("") || data.password.value.equals("")) {
            data.setErrorMessage("Please enter all the fields")
        } else {
            data.setErrorMessage("")
            loginData(
                data.email.value?.replace(".", ""), data.password.value
            )
        }
    }

    private fun loginData(email: String?, password: String?) {
        val databaseRef = dbReference.child(email.toString())
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(UserInfo::class.java)
                if (value != null) {
                    if (value.email.equals(email) && value.password.equals(password)) {
                        saveDataToModel(value)
                        updateEvent(LoginEvents.OnLoginClicked)
                    } else {
                        data.setErrorMessage("incorrect password")
                    }
                } else {
                    data.setErrorMessage("user does not exist")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                data.setErrorMessage("Unable to fetch the data")
            }
        })
    }

    private fun saveDataToModel(user: UserInfo) {
        User.userEmail = user.email.toString()
        User.userPassword = user.password.toString()
        User.userName = user.username.toString()
        User.userBio = user.bio.toString()
    }
}