package com.example.data.repository

import com.example.data.source.weather.WeatherRemoteSource
import com.example.domain.model.WeatherModel
import com.example.domain.repository.WeatherRepository
import com.example.core.Error
import com.example.core.Result

class WeatherRepositoryImpl(private val source: WeatherRemoteSource) :
    WeatherRepository {

    override suspend fun getWeather(
        accessKey: String,
        query: String
    ): Result<Error, WeatherModel> =
        source.getWeather(accessKey, query)
}