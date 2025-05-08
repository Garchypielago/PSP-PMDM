package com.example.finalproject.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.models.MainState
import com.example.finalproject.models.ResponseCart
import kotlinx.coroutines.launch

class CartViewModel : ViewModel() {

    private val myState = MainState()
    private val _data = MutableLiveData<ResponseCart>(ResponseCart())
    val data: LiveData<ResponseCart> get() = _data

    private val _data2 = MutableLiveData<String>("")
    val data2: LiveData<String> get() = _data2

    fun returnCart() {
        viewModelScope.launch {
            _data.value = myState.returnCart()
        }
    }

    fun addProductToCart(productId: Long, count: Long) {
        viewModelScope.launch {
            _data2.value = myState.addProductToCart(productId, count)
        }
    }

    fun deleteProductFromCart(productId: Long) {
        viewModelScope.launch {
            _data2.value = myState.deleteProductFromCart(productId)
            _data.value = myState.returnCart()
        }
    }

}