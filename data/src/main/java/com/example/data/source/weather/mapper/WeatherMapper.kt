package com.example.data.source.weather.mapper

import com.example.data.entity.WeatherEntity
import com.example.domain.model.WeatherModel

interface WeatherMapper {
    fun toWeather(entity: WeatherEntity): WeatherModel
}