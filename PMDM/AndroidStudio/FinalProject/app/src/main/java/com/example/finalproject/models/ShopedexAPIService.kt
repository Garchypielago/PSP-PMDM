package com.example.finalproject.models

import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ShopedexAPIService {

    @GET("products/find")
    suspend fun getAllProducts(@Query("pageNumber") pageNumber: Long = 1): Response<ResponseShopedex>

    @GET("products/find")
    suspend fun getTypeProducts(@Query("type") type: Long, @Query("pageNumber") pageNumber: Long = 1): Response<ResponseShopedex>

    @GET("products/find")
    suspend fun getRegionProducts(@Query("region") region: Long, @Query("pageNumber") pageNumber: Long = 1): Response<ResponseShopedex>

    @GET("products/find")
    suspend fun getTypeRegionProducts(
        @Query("type") type: Long,
        @Query("region") region: Long,
        @Query("pageNumber") pageNumber: Long = 1
    ): Response<ResponseShopedex>


    @GET("cart")
    suspend fun getCart(): Response<ResponseCart>

    @POST("cart/{productId}/{count}")
    suspend fun addProductToCart(
        @Path("productId") productId: Long,
        @Path("count") count: Long
    ): Response<ResponseCart>

    @DELETE("cart/{productId}")
    suspend fun deleteProductFromCart(@Path("productId") productId: Long): Response<ResponseCart>
}