package com.example.finalproject.models

import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainState {
//    var baseUrl = "http://10.0.2.2:8080/contextpath/api/app/v1/"
//    var baseUrl = "http://192.168.1.189:8080/contextpath/api/app/v1/"
//    var baseUrl = "http://192.168.1.46:8080/contextpath/api/app/v1/"
    var baseUrl = "http://10.227.189.204:8080/contextpath/api/app/v1/"


    suspend fun returnAllProducts(nextPage: Long = 1): ResponseShopedex {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return service.getAllProducts(nextPage).body() ?: ResponseShopedex()
    }

    suspend fun returnTypeProducts(type: Long, nextPage: Long = 1): ResponseShopedex {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return service.getTypeProducts(type, nextPage).body() ?: ResponseShopedex()
    }

    suspend fun returnRegionProducts(region: Long, nextPage: Long = 1): ResponseShopedex {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return service.getRegionProducts(region, nextPage).body() ?: ResponseShopedex()
    }

    suspend fun returnTypeRegionProducts(type: Long, region: Long, nextPage: Long = 1): ResponseShopedex {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return service.getTypeRegionProducts(type, region, nextPage).body() ?: ResponseShopedex()
    }

    suspend fun returnCart(): ResponseCart {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return service.getCart().body() ?: ResponseCart()
    }

    suspend fun addProductToCart(productId: Long, count: Long): String  {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return try {
            val response = service.addProductToCart(productId, count)
            if (response.isSuccessful) {
                "Pokemon added  successfully"
            } else {
                "Error ${response.code()}: ${response.errorBody()?.string()}"
            }
        } catch (e: HttpException) {
                "HTTP Error ${e.code()}: ${e.message()}"
        } catch (e: Exception) {
            "General Error: ${e.localizedMessage}"
        }
    }


    suspend fun deleteProductFromCart(productId: Long): String {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return try {
            val response = service.deleteProductFromCart(productId)
            if (response.isSuccessful) {
                "Pokemon deleted successfully"
            } else {
                "Error ${response.code()}: ${response.errorBody()?.string()}"
            }
        } catch (e: HttpException) {
            "HTTP Error ${e.code()}: ${e.message()}"
        } catch (e: Exception) {
            "General Error: ${e.localizedMessage}"
        }
    }


}