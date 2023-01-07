package com.example.api_calling.Api

import com.example.apicalling.Retrofit.RetroApiModelItem
import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface {

    @GET("products")
    fun getProduct() : Call<List<RetroApiModelItem>>
}
