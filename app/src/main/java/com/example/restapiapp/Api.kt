package com.example.restapiapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://ict-yep-backend.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())

        .build()

    val studentapi: RestApi = retrofit.create(RestApi::class.java)
}