package com.example.domain.repository

import com.example.domain.model.WeatherModel
import com.example.core.Error
import com.example.core.Result
import com.example.domain.param.WeatherParams

interface WeatherRepository {
    suspend fun getWeather(
        accessKey: String,
        query: String
    ): Result<Error, WeatherModel>
}