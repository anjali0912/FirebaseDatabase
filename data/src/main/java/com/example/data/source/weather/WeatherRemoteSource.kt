package com.example.data.source.weather

import com.example.core.ResponseMapper
import com.example.domain.model.WeatherModel
import com.example.core.Error
import com.example.core.Result

interface WeatherRemoteSource : ResponseMapper {
    suspend fun getWeather(
        accessKey: String,
        query: String
    ): Result<Error, WeatherModel>
}