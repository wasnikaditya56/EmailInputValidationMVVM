package com.aditya.wasnik.emailinputvalidation.data.api

import com.aditya.wasnik.emailinputvalidation.model.LoginBody
import com.aditya.wasnik.emailinputvalidation.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiServices {
@Headers("Content-Type: application/json")
@POST(/api/login)
    fun login2(
        @Body loginBody: LoginBody
    ): Call<LoginResponse>
}
