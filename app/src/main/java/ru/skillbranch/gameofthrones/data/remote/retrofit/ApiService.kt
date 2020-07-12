package ru.skillbranch.gameofthrones.data.remote.retrofit

import retrofit2.Call
import retrofit2.http.GET
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

interface ApiService {

    @GET("houses")
    fun getAllHouses(): Call<List<HouseRes>>

}