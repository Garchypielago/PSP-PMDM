package com.example.finalproject.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.models.MainState
import com.example.finalproject.models.ResponseToken
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val myState = MainState()
    private val _data = MutableLiveData<ResponseToken>(ResponseToken())
    val data: LiveData<ResponseToken> get() = _data

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _data.value = myState.login(email, password)
        }
    }

}