package com.example.golem.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.golem.CharacterData
import com.example.golem.api.ApiRnM
import com.example.golem.api.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharactersViewModel: ViewModel() {

     var charactersDataList = MutableLiveData<List<CharacterData>>()

     fun getApiData(){
        val retrofitService = RetrofitInstance.getRetrofitInstance().create(ApiRnM::class.java)
        retrofitService.getListCharacters().enqueue(object: Callback<List<CharacterData>>{
             override fun onResponse(
                  call: Call<List<CharacterData>>,
                  response: Response<List<CharacterData>>,
             ) {
                charactersDataList.value = response.body()
             }

             override fun onFailure(call: Call<List<CharacterData>>, t: Throwable) {
             }
        })
     }
}