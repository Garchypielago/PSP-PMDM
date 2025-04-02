package com.example.recycleview.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _data = MutableLiveData<List<String>>(emptyList())
    val data: LiveData<List<String>> get() = _data
    val myState = MainState()

    private val _delete: MutableLiveData<MyData> = MutableLiveData<MyData>()
    val delete: LiveData<MyData> get() = _delete

    private val _add: MutableLiveData<MyData> = MutableLiveData<MyData>()
    val add: LiveData<MyData> get() = _add

    fun returnList(){
        viewModelScope.launch {
            var returnData = myState.returnList()
            _data.value = returnData
        }
    }

    fun delete(position : Int){
        viewModelScope.launch {
            _delete.value = myState.delete(position)
        }
    }

    fun add(position: Int, name: String){
        viewModelScope.launch {
            _add.value = myState.add(position, name)
        }
    }


}