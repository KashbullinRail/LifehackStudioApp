package com.example.lifehackstudioapp

import android.app.Application
import com.example.lifehackstudioapp.detail_screen.di.detailScreenModule
import com.example.lifehackstudioapp.main_screen.di.mainScreenModule
import com.example.newsfetcher.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                networkModule,
                mainScreenModule,
                detailScreenModule
            )
        }
    }

}