package com.example.data.entity

data class WeatherPayload(val payload: WeatherPayloadItem)

data class WeatherPayloadItem(
    val latitude: Double,
    val longitude: Double,
    val exclude: String,
    val apiKey: String
)