package com.example.lifecycle.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifecycle.model.Datos
import com.example.lifecycle.model.MainState
import kotlinx.coroutines.launch

class MainViewModel : ViewModel () {
    private val _datos = MutableLiveData(Datos(0,0,false))
    val datos: LiveData<Datos> get() = _datos
    val myEstado = MainState()

    fun add(valor: Int, misDatos: Datos){
        viewModelScope.launch {
            var retornoDatos = myEstado.add(valor, misDatos)
            _datos.value = retornoDatos
        }
    }
}