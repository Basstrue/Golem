package com.example.golem.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    val api: ApiRnM by lazy {
       Retrofit.Builder()
           .baseUrl("https://rickandmortyapi.com")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
           .create(ApiRnM::class.java)
    }
}