package com.example.domain.usecase

import com.example.domain.model.WeatherModel
import com.example.domain.param.WeatherParams
import com.example.domain.repository.WeatherRepository
import kotlin.coroutines.CoroutineContext
import com.example.core.Error
import com.example.core.Result

class WeatherUseCaseImpl(private val repository: WeatherRepository) : WeatherUseCase {
    override suspend fun execute(
        params: WeatherParams, coroutineContext: CoroutineContext
    ): Result<Error, WeatherModel> =
        repository.getWeather(
            params.accessKey,
            params.query
        )
}