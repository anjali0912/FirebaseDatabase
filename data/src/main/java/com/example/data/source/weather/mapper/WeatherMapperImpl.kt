package com.example.data.source.weather.mapper

import com.example.data.entity.WeatherEntity
import com.example.domain.model.WeatherModel

class WeatherMapperImpl : WeatherMapper {

    override fun toWeather(entity: WeatherEntity) =
        WeatherModel(
            humidity = entity.current.humidity ?: 0,
            pressure = entity.current.pressure ?: 0,
            temperature = entity.current.temperature ?: 0,
            windDegree = entity.current.wind_degree ?: 0,
            windSpeed = entity.current.wind_speed ?: 0,
            country = entity.location.country.orEmpty(),
            lat = entity.location.lat.orEmpty(),
            lon = entity.location.lon.orEmpty(),
            name = entity.location.name.orEmpty(),
            region = entity.location.region.orEmpty(),
            timezone = entity.location.timezone_id.orEmpty()
        )
}