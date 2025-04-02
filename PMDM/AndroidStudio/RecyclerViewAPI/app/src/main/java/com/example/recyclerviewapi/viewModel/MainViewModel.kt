package com.example.recyclerviewapi.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewapi.model.MainState
import com.example.recyclerviewapi.model.ResponseDog
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val myState = MainState()
    private val _data = MutableLiveData<ResponseDog>(ResponseDog(null.toString(),ArrayList()))
    val data: LiveData<ResponseDog> get() = _data

    fun returnPhotos(breed: String){
        viewModelScope.launch{
            _data.value = myState.returnPhotos(breed)
        }
    }

}