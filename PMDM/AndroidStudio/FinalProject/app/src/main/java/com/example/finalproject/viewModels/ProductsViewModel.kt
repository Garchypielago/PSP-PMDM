package com.example.finalproject.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.models.MainState
import com.example.finalproject.models.ResponseShopedex
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {

    private val myState = MainState()
    private val _data = MutableLiveData<ResponseShopedex>(ResponseShopedex())
    val data: LiveData<ResponseShopedex> get() = _data

    fun returnAllProducts(nextPage: Long = 1) {
        viewModelScope.launch {
            _data.value = myState.returnAllProducts(nextPage)
        }
    }

    fun returnTypeProducts(type: Long, nextPage: Long = 1) {
        viewModelScope.launch {
            _data.value = myState.returnTypeProducts(type, nextPage)
        }
    }

    fun returnRegionProducts(region: Long, nextPage: Long = 1) {
        viewModelScope.launch {
            _data.value = myState.returnRegionProducts(region, nextPage)
        }
    }

    fun returnTypeRegionProducts(type: Long, region: Long, nextPage: Long = 1) {
        viewModelScope.launch {
            _data.value = myState.returnTypeRegionProducts(type, region, nextPage)
        }
    }

}