package ru.skillbranch.gameofthrones.repositories

import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

interface DatabaseRepository {

    fun insertHouses(houses : List<HouseRes>, onComplete: () -> Unit)

    fun insertCharacters(characters : List<CharacterRes>, onComplete: () -> Unit)

    fun drop(onComplete: () -> Unit)

    fun needUpdate(result: (need : Boolean) -> Unit)

}