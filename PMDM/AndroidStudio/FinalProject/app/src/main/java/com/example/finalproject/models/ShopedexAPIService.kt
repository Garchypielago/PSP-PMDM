package com.example.finalproject.models

import com.example.finalproject.entities.UserDTO
import com.example.finalproject.utils.constants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ShopedexAPIService {

    @POST("api/v1/auth/register")
    suspend fun register(
        @Body userDTO: UserDTO
    ): Response<ResponseToken>

    @POST("api/v1/auth/login")
    suspend fun login(
        @Body userDTO: UserDTO
    ): Response<ResponseToken>

    @GET("products/find")
    suspend fun getAllProducts(
        @Header("Authorization") token: String,
        @Query("pageNumber") pageNumber: Long = 1
    ): Response<ResponseShopedex>

    @GET("products/find")
    suspend fun getTypeProducts(
        @Header("Authorization") token: String,
        @Query("type") type: Long, @Query("pageNumber") pageNumber: Long = 1
    ): Response<ResponseShopedex>

    @GET("products/find")
    suspend fun getRegionProducts(
        @Header("Authorization") token: String,
        @Query("region") region: Long, @Query("pageNumber") pageNumber: Long = 1
    ): Response<ResponseShopedex>

    @GET("products/find")
    suspend fun getTypeRegionProducts(
        @Header("Authorization") token: String,
        @Query("type") type: Long,
        @Query("region") region: Long,
        @Query("pageNumber") pageNumber: Long = 1
    ): Response<ResponseShopedex>


    @GET("cart")
    suspend fun getCart(
        @Header("Authorization") token: String
    ): Response<ResponseCart>

    @POST("cart/{productId}/{count}")
    suspend fun addProductToCart(
        @Header("Authorization") token: String,
        @Path("productId") productId: Long,
        @Path("count") count: Long
    ): Response<ResponseCart>

    @DELETE("cart/{productId}")
    suspend fun deleteProductFromCart(
        @Header("Authorization") token: String,
        @Path("productId") productId: Long
    ): Response<ResponseCart>
}