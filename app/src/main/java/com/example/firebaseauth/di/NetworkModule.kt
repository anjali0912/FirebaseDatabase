package com.example.firebaseauth.di

import com.example.core.REST_CLIENT_MODULE
import com.example.core.RestClientModule
import org.koin.core.qualifier.named
import org.koin.dsl.module
import com.example.core.RestClientModule.getClient

internal const val BASE_URL = "http://api.weatherstack.com/"
const val TIME_OUT = 45L
internal const val QUERY = "India"

val networkModule = module {

    single(named(REST_CLIENT_MODULE)) {
        RestClientModule.build(
            BASE_URL,
            getClient(TIME_OUT)
        )
    }
}