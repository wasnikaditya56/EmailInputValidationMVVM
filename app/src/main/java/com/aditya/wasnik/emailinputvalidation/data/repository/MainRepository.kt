package com.aditya.wasnik.emailinputvalidation.data.repository

import com.aditya.wasnik.emailinputvalidation.data.datasource.RemoteDataSource
import com.aditya.wasnik.emailinputvalidation.model.LoginBody

class MainRepository(private val remoteDataSource: RemoteDataSource) {
    fun login(loginBody: LoginBody) = remoteDataSource.register(loginBody)
}