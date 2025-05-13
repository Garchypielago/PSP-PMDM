package com.example.finalproject.models

import com.example.finalproject.entities.UserDTO
import com.example.finalproject.utils.constants
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainState {

    var baseUrl = constants.API_URL

//    suspend fun register(email: String, password: String, firstName: String, lastName: String): ResponseToken {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(constants.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val service = retrofit.create(ShopedexAPIService::class.java)
//
//        return service.register(UserDTO(email, password, firstName, lastName)).body() ?: ResponseToken()
//    }

    suspend fun login(email: String, password: String): ResponseToken {
        val retrofit = Retrofit.Builder()
            .baseUrl(constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return try {
            val response = service.login(UserDTO(email, password))
            if (response.isSuccessful) {
                return response.body() ?: ResponseToken()
            }
            return ResponseToken()
        } catch (e: Exception) {
            return ResponseToken()
        }

    }

    suspend fun returnAllProducts(nextPage: Long = 1): ResponseShopedex {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return service.getAllProducts(constants.ACCESS_TOKEN, nextPage).body() ?: ResponseShopedex()
    }

    suspend fun returnTypeProducts(type: Long, nextPage: Long = 1): ResponseShopedex {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return service.getTypeProducts(constants.ACCESS_TOKEN, type, nextPage).body()
            ?: ResponseShopedex()
    }

    suspend fun returnRegionProducts(region: Long, nextPage: Long = 1): ResponseShopedex {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return service.getRegionProducts(constants.ACCESS_TOKEN, region, nextPage).body()
            ?: ResponseShopedex()
    }

    suspend fun returnTypeRegionProducts(
        type: Long,
        region: Long,
        nextPage: Long = 1
    ): ResponseShopedex {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return service.getTypeRegionProducts(constants.ACCESS_TOKEN, type, region, nextPage).body()
            ?: ResponseShopedex()
    }

    suspend fun returnCart(): ResponseCart {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return service.getCart(constants.ACCESS_TOKEN).body() ?: ResponseCart()
    }

    suspend fun addProductToCart(productId: Long, count: Long): String {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShopedexAPIService::class.java)

        return try {
            val response = service.addProductToCart(constants.ACCESS_TOKEN, productId, count)
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
            val response = service.deleteProductFromCart(constants.ACCESS_TOKEN, productId)
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