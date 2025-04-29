package com.example.finalproject.models

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ShopedexAPIService {

    @GET("products/find")
    suspend fun getAllProducts(): Response<ResponseShopedex>

    @GET("products/find")
    suspend fun getTypeProducts(@Query("type") type: Long): Response<ResponseShopedex>

    @GET("products/find")
    suspend fun getRegionProducts(@Query("region") region: Long): Response<ResponseShopedex>

    @GET("products/find")
    suspend fun getTypeRegionProducts(@Query("type") type: Long, @Query("region") region: Long): Response<ResponseShopedex>

    @POST("cart/{productId}/{count}")
    suspend fun addProductToCart(@Path("productId") productId: Long, @Path("count") count: Long): Response<ResponseShopedex>

}