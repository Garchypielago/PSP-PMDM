package com.example.lifecycle.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifecycle.model.Datos
import com.example.lifecycle.model.MainState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModelFlow : ViewModel() {
//    private val _datos = MutableLiveData(Datos(0,0,false))
    private val _datos = MutableStateFlow(Datos(0,0,false))
    val datos: StateFlow<Datos> get() = _datos.asStateFlow()
    val myEstado = MainState()

    fun add(valor: Int, misDatos: Datos){
        viewModelScope.launch {
            var retornoDatos = myEstado.add(valor, misDatos)
            _datos.value = retornoDatos
        }
    }
}
