package com.example.firebaseauth.features.login

import androidx.lifecycle.MutableLiveData
import com.example.core.BaseData

data class LoginData(
    val email: MutableLiveData<String> = MutableLiveData(""),
    val password: MutableLiveData<String> = MutableLiveData(""),
    val errorMessage: MutableLiveData<String> = MutableLiveData("")
) : BaseData() {

    fun setErrorMessage(errorMessage: String) {
        this.errorMessage.postValue(errorMessage)
    }
}