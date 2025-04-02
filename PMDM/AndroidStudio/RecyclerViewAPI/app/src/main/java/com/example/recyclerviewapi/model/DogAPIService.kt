package com.example.recyclerviewapi.model

import retrofit2.Response
import retrofit2.http.GET

interface DogAPIService {

    @GET("images")
    suspend fun getDogPhotos(): Response<ResponseDog>
}