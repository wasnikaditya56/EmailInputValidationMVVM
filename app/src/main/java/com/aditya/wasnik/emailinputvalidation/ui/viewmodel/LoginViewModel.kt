package com.aditya.wasnik.emailinputvalidation.ui.viewmodel

import android.os.Handler.Callback
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aditya.wasnik.emailinputvalidation.data.repository.MainRepository
import com.aditya.wasnik.emailinputvalidation.model.LoginBody
import com.aditya.wasnik.emailinputvalidation.model.LoginResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class LoginViewModel(private val repository: MainRepository): ViewModel() {
    fun Login(loginBody: LoginBody) = viewModelScope.launch {
        Log.d("hasillog",loginBody.toString())
        repository.login(loginBody).collect{
            it.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    Log.d("hasil", "res")
                    Log.d("hasil", "res :${response.toString()}")
                    val dataTOken = response.body()?.data
                    Log.d("hasil", "res :${dataTOken.toString()}")
                    Log.d("hasil", "token :${dataTOken?.token.toString()}")
                    Log.d("hasil", "res2 :${response.body().toString()}")
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.d("hasil", "error")
                }
            })
        }
    }
}

p

}
