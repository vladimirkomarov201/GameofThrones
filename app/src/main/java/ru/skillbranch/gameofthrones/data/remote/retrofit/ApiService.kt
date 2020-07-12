package ru.skillbranch.gameofthrones.data.remote.retrofit

import io.reactivex.Observable
import retrofit2.http.GET
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

interface ApiService {

    @GET("houses")
    fun getAllHouses(): Observable<List<HouseRes>>

}