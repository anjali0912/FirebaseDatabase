package com.example.data.source.weather

import com.example.data.source.weather.api.GetWeatherApi
import com.example.data.source.weather.mapper.WeatherMapper
import com.example.domain.model.WeatherModel
import com.example.core.Error
import com.example.core.Result

class WeatherRemoteSourceImpl(
    private val getWeatherApi: GetWeatherApi,
    val mapper: WeatherMapper
) : WeatherRemoteSource {

    override suspend fun getWeather(
        accessKey: String,
        query: String
    ): Result<Error, WeatherModel> =
        execute(
            service = {
                getWeatherApi.getWeather(
                    accessKey,
                    query
                )
            },
            success = { weatherEntity, _ -> mapper.toWeather(weatherEntity) },
            failure = { Error.RemoteError() }
        )
}