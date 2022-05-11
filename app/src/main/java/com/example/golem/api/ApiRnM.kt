package com.example.golem.api

import com.example.golem.CharacterData
import retrofit2.http.GET

interface ApiRnM {
    @GET("/api/character")
    fun getListCharacters(): retrofit2.Response<List<CharacterData>>
}