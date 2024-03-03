package com.aditya.wasnik.emailinputvalidation.di

import android.content.Context
import com.aditya.wasnik.emailinputvalidation.data.api.ApiConfig
import com.aditya.wasnik.emailinputvalidation.data.datasource.RemoteDataSource
import com.aditya.wasnik.emailinputvalidation.data.repository.MainRepository

object Injection {
    fun provideRepository(context: Context): MainRepository{
        val apiServices = ApiConfig.getApiServices()
        val remoteDataSource = RemoteDataSource(apiServices)
        return MainRepository(remoteDataSource)
    }
}