package com.example.domain.usecase

import com.example.core.BaseUseCase
import com.example.domain.model.WeatherModel
import com.example.domain.param.WeatherParams

interface WeatherUseCase :
    BaseUseCase<WeatherParams, WeatherModel> {
}