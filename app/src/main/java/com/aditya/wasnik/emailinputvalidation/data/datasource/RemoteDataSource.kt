package com.aditya.wasnik.emailinputvalidation.data.datasource

import android.util.Log
import com.aditya.wasnik.emailinputvalidation.data.api.ApiServices
import com.aditya.wasnik.emailinputvalidation.model.LoginBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiServices: ApiServices) {
    fun register(loginBody: LoginBody) = flow {
        emit(apiServices.login2(loginBody))
    }.catch {
        Log.d("login", "login: failed = ${it.message}")
    }.flowOn(Dispatchers.IO)
}