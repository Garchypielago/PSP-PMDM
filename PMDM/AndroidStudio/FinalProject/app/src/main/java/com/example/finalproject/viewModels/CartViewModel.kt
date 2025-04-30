package com.example.finalproject.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.models.MainState
import com.example.finalproject.models.ResponseCart
import kotlinx.coroutines.launch

class CartViewModel: ViewModel() {

    private val myState = MainState()
    private val _data = MutableLiveData<ResponseCart>(ResponseCart())
    val data: LiveData<ResponseCart> get() = _data

    fun returnCart(){
        viewModelScope.launch{
            _data.value = myState.returnCart()
        }
    }
    fun addProductToCart(productId: Long, count: Long){
        viewModelScope.launch{
            _data.value = myState.addProductToCart(productId, count)
        }
    }

}