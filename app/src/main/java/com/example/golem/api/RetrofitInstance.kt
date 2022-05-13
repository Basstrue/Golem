package com.example.golem.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    fun getRetrofitInstance(): Retrofit{
       return Retrofit.Builder()
           .baseUrl("https://rickandmortyapi.com")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
    }
}