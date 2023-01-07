package com.example.api_calling.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Apiclient {

    var BASEURL = "https://fakestoreapi.com/"

    fun getRetrofit(): Retrofit {

        return Retrofit.Builder().baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}