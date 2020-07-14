package ru.skillbranch.gameofthrones.data.local.converters

import ru.skillbranch.gameofthrones.data.local.room.entity.character.CharacterDatabase
import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes

fun CharacterRes.toDbEntity(): CharacterDatabase{
    return CharacterDatabase(
        id = 0,
        name = name,
        born = born,
        culture = culture,
        died = died,
        father = father,
        gender = gender,
        //TODO
        houseId = "",
        mother = mother,
        spouse = spouse
    )
}

fun List<CharacterRes>.toDbEntity(): List<CharacterDatabase>{
    return this.map {
        it.toDbEntity()
    }
}