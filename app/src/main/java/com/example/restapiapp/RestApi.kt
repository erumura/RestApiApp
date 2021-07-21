package com.example.restapiapp

import android.content.ClipData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface RestApi {
    @POST("students")
    fun postStudent(): Call<List<Post>>

 @GET("items")
 fun getItems(): Call<List<GET>>
}