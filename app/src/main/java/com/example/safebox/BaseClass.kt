package com.example.safebox

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class BaseClass():Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@BaseClass)
            modules(listOf(appModule))
        }
    }

    private val appModule = module{
        //   single { AdsRepository(this@MainApplication) }
        viewModel { MainViewModel() }

    }
}