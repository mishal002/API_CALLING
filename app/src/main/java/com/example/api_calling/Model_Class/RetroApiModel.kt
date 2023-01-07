package com.example.apicalling.Retrofit

import com.google.gson.annotations.SerializedName

data class RetroApiModel(

    @field:SerializedName("RetroApiModel")
    val retroApiModel: List<RetroApiModelItem?>? = null,
)

data class RetroApiModelItem(

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("price")
    val price: Double? = null,

    @field:SerializedName("rating")
    val rating: Rating? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("category")
    val category: String? = null,
)

data class Rating(

    @field:SerializedName("rate")
    val rate: Double? = null,

    @field:SerializedName("count")
    val count: Int? = null,
)
