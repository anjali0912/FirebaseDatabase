package com.example.firebaseauth

import android.app.Application
import com.example.data.di.apiModule
import com.example.data.di.mapperModule
import com.example.data.di.repositoryModule
import com.example.data.di.sourceModule
import com.example.domain.di.useCaseModule
import com.example.firebaseauth.di.networkModule
import com.example.firebaseauth.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FirebaseAuth : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@FirebaseAuth)
            modules(
                listOf(
                    apiModule,
                    networkModule,
                    presentationModule,
                    useCaseModule,
                    repositoryModule,
                    sourceModule,
                    mapperModule,
                )
            )
        }
    }
}