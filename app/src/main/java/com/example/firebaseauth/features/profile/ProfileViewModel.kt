package com.example.firebaseauth.features.profile

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.core.BaseViewModel
import com.example.domain.model.WeatherModel
import com.example.domain.param.WeatherParams
import com.example.domain.usecase.WeatherUseCase
import com.example.firebaseauth.BuildConfig
import com.example.firebaseauth.User
import com.example.firebaseauth.di.QUERY
import kotlinx.coroutines.launch

class ProfileViewModel(
    application: Application,
    data: ProfileData,
    private val weatherUseCase: WeatherUseCase
) : BaseViewModel<ProfileData, ProfileEvents>(application, data) {

    init {
        setUserInfo()
        getWeather()
    }

    private fun setUserInfo() {
        data.setUsername(User.userName)
        data.setBio(User.userBio)
    }

    private fun getWeather() {
        viewModelScope.launch {
            weatherUseCase.execute(
                WeatherParams(
                    accessKey = BuildConfig.ACCESS_KEY,
                    query = QUERY
                )
            ).mapResult(
                success = { weatherModel ->
                    setWeatherInfo(weatherModel)
                },
                failure = {
                })
        }
    }

    private fun setWeatherInfo(weatherModel: WeatherModel) {
        data.setHumidity(weatherModel.humidity.toString())
        data.setPressure(weatherModel.pressure.toString())
        data.setTemperature(weatherModel.temperature.toString())
        data.setWindDegree(weatherModel.windDegree.toString())
        data.setWindSpeed(weatherModel.windSpeed.toString())
        data.setLatLon("${weatherModel.lat.toString()},${weatherModel.lon.toString()}")
        data.setCountry("${weatherModel.name.toString()},${weatherModel.region.toString()},${weatherModel.country.toString()}")
        data.setTimeZone(weatherModel.timezone.toString())
    }
}