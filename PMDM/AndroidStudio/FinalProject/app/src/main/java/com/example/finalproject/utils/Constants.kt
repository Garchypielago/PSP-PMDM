package com.example.finalproject.utils

object constants {
//    const val IP_ADDRESS = "10.227.189.204"
//    const val IP_ADDRESS = "192.168.1.46"
    const val IP_ADDRESS = "10.227.189.197"
//    const val IP_ADDRESS = "192.168.1.150"

    const val BASE_URL = "http://$IP_ADDRESS:8080/contextpath/"
    const val API_URL = BASE_URL + "api/app/v1/"

    var ACCESS_TOKEN = "Bearer "
    var REFRESH_TOKEN = "Bearer "
    var USERNAME = ""
}