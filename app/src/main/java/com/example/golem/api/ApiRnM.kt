package com.example.golem.api

import com.example.golem.CharacterData
import retrofit2.Call
import retrofit2.http.GET

interface ApiRnM {
    @GET("/api/character")
    fun getListCharacters(): Call<List<CharacterData>>
}