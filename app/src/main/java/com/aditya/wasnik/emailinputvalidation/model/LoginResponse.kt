package com.aditya.wasnik.emailinputvalidation.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @field:SerializedName("data")
    val data: LoginResult,

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("message")
    val message: String
)

data class LoginResult(
    @field:SerializedName("token")
    val token: String
)
