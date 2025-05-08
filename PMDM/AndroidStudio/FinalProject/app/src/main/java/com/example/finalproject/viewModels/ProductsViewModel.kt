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

    fun returnAllProducts() {
        viewModelScope.launch {
            _data.value = myState.returnAllProducts()
        }
    }

    fun returnTypeProducts(type: Long) {
        viewModelScope.launch {
            _data.value = myState.returnTypeProducts(type)
        }
    }

    fun returnRegionProducts(region: Long) {
        viewModelScope.launch {
            _data.value = myState.returnRegionProducts(region)
        }
    }

    fun returnTypeRegionProducts(type: Long, region: Long) {
        viewModelScope.launch {
            _data.value = myState.returnTypeRegionProducts(type, region)
        }
    }

}