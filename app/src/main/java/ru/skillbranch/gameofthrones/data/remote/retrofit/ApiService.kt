package ru.skillbranch.gameofthrones.data.remote.retrofit

import io.reactivex.Maybe
import retrofit2.http.GET
import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

interface ApiService {

    @GET("houses?pageSize=10&page=1")
    fun getAllHouses(): Maybe<List<HouseRes>>

    @GET("characters")
    fun getAllCharacters(): Maybe<List<CharacterRes>>

}