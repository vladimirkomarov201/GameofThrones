package ru.skillbranch.gameofthrones.repositories.impls

import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes
import ru.skillbranch.gameofthrones.repositories.DatabaseRepository

class RoomDatabase: DatabaseRepository {
    override fun insertHouses(houses: List<HouseRes>, onComplete: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun insertCharacters(characters: List<CharacterRes>, onComplete: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun drop(onComplete: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun needUpdate(result: (need: Boolean) -> Unit) {
        TODO("Not yet implemented")
    }
}