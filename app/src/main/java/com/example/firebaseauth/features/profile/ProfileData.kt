package com.example.firebaseauth.features.profile

import androidx.lifecycle.MutableLiveData
import com.example.core.BaseData

data class ProfileData(
    val username: MutableLiveData<String> = MutableLiveData(""),
    val bio: MutableLiveData<String> = MutableLiveData(""),
    val humidity: MutableLiveData<String> = MutableLiveData(""),
    val pressure: MutableLiveData<String> = MutableLiveData(""),
    val temperature: MutableLiveData<String> = MutableLiveData(""),
    val windDegree: MutableLiveData<String> = MutableLiveData(""),
    val windSpeed: MutableLiveData<String> = MutableLiveData(""),
    val latLon: MutableLiveData<String> = MutableLiveData(""),
    val country: MutableLiveData<String> = MutableLiveData(""),
    val timeZone: MutableLiveData<String> = MutableLiveData("")
) : BaseData() {

    fun setUsername(value: String) {
        this.username.postValue(value)
    }

    fun setBio(value: String) {
        this.bio.postValue(value)
    }

    fun setHumidity(value: String) {
        this.humidity.postValue(value)
    }

    fun setPressure(value: String) {
        this.pressure.postValue(value)
    }

    fun setTemperature(value: String) {
        this.temperature.postValue(value)
    }

    fun setWindDegree(value: String) {
        this.windDegree.postValue(value)
    }

    fun setWindSpeed(value: String) {
        this.windSpeed.postValue(value)
    }

    fun setLatLon(value: String) {
        this.latLon.postValue(value)
    }

    fun setCountry(value: String) {
        this.country.postValue(value)
    }

    fun setTimeZone(value: String) {
        this.timeZone.postValue(value)
    }
}