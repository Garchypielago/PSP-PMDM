package com.example.finalproject.models

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainState {
//    var baseUrl = "http://10.0.2.2:8080/contextpath/api/app/v1/"
//    var baseUrl = "http://192.168.1.189:8080/contextpath/api/app/v1/"
    var baseUrl = "http://192.168.1.46:8080/contextpath/api/app/v1/"
//    var baseUrl = "http://10.227.189.180:8080/contextpath/api/app/v1/"


    suspend fun returnAllProducts(): ResponseShopedex {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return service.getAllProducts().body() ?: ResponseShopedex()
    }

    suspend fun returnTypeProducts(type: Long): ResponseShopedex {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return service.getTypeProducts(type).body() ?: ResponseShopedex()
    }

    suspend fun returnRegionProducts(region: Long): ResponseShopedex {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return service.getRegionProducts(region).body() ?: ResponseShopedex()
    }

    suspend fun returnTypeRegionProducts(type: Long, region: Long): ResponseShopedex {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return service.getTypeRegionProducts(type, region).body() ?: ResponseShopedex()
    }

    suspend fun returnCart(): ResponseCart{
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return service.getCart().body() ?: ResponseCart()
    }

    suspend fun addProductToCart(productId: Long, count: Long): ResponseCart {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return service.addProductToCart(productId, count).body() ?: ResponseCart()
    }


}