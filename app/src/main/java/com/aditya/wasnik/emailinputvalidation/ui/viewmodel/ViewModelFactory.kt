package com.aditya.wasnik.emailinputvalidation.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aditya.wasnik.emailinputvalidation.data.repository.MainRepository
import com.aditya.wasnik.emailinputvalidation.di.Injection

class ViewModelFactory(private val mainRepository: MainRepository):
ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       if (modelClass.isAssignableFrom(LoginViewModel::class.java)){
           return LoginViewModel(mainRepository) as T
       }
        throw IllegalArgumentException("unknown ViewModel class: "+ modelClass.name)
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this){
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }.also {
                instance = it
            }
    }
}