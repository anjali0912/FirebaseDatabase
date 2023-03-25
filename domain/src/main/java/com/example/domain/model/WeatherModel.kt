package com.example.domain.model

data class WeatherModel(
    val humidity: Int,
    val pressure: Int,
    val temperature: Int,
    val windDegree: Int,
    val windSpeed: Int,
    val country: String,
    val lat: String,
    val lon: String,
    val name: String,
    val region: String,
    val timezone: String
)