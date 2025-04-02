package com.example.recyclerviewapi.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainState {
    var cadena = "https://dog.ceo/api/breed/"

    suspend fun returnPhotos(raza: String): ResponseDog {
        val cadenaFinal = cadena + raza + "/"
        val retrofit = Retrofit.Builder()
            .baseUrl(cadenaFinal)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val call = retrofit.create(DogAPIService::class.java).getDogPhotos()
        val fotosPerros = call.body()
        if (fotosPerros != null) {
            return fotosPerros
        } else {
            return ResponseDog(status = "no success", message = null)
        }
    }
}
