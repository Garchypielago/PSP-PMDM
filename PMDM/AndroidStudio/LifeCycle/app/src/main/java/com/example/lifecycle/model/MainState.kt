package com.example.lifecycle.model

class MainState {

    fun add(valor : Int, datos: Datos): Datos {
        datos.contador += valor
        datos.numClicks++

        if (datos.numClicks%5==0){
            datos.showMessage = true
        }

        return datos
        }
}