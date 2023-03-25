package com.example.firebaseauth.features.register

import androidx.lifecycle.MutableLiveData
import com.example.core.BaseData

data class RegisterData(
    val email: MutableLiveData<String> = MutableLiveData(""),
    val password: MutableLiveData<String> = MutableLiveData(""),
    val username: MutableLiveData<String> = MutableLiveData(""),
    val bio: MutableLiveData<String> = MutableLiveData(""),
    val errorMessage: MutableLiveData<String> = MutableLiveData("")
) : BaseData() {

    fun setErrorMessage(errorMessage: String) {
        this.errorMessage.postValue(errorMessage)
    }
}