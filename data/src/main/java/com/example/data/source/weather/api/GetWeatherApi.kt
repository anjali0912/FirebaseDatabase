package com.example.data.source.weather.api

import com.example.data.entity.WeatherEntity
import retrofit2.Response
import retrofit2.http.*

interface GetWeatherApi {

    @GET("current")
    @Headers("Content-Type: application/json;charset=UTF-8", "Accept: application/json")
    suspend fun getWeather(
        @Query("access_key") accessKey: String,
        @Query("query") query: String
    ): Response<WeatherEntity>
}