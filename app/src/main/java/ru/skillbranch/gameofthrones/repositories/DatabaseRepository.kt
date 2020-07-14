package ru.skillbranch.gameofthrones.repositories

import io.reactivex.Completable
import io.reactivex.Single
import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

interface DatabaseRepository {

    fun insertHouses(houses: List<HouseRes>): Single<List<Long>>

    fun insertCharacters(characters: List<CharacterRes>): Single<List<Long>>

    fun drop(): Completable

    fun needUpdate(): Single<Boolean>

}