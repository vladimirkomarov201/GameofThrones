package ru.skillbranch.gameofthrones.data.local.converters

import ru.skillbranch.gameofthrones.data.local.entities.House
import ru.skillbranch.gameofthrones.data.local.room.entity.house.HouseDatabase
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

fun HouseRes.toHouse(): House{
    return House(
        id = "0",
        ancestralWeapons = ancestralWeapons,
        coatOfArms = coatOfArms,
        currentLord = currentLord,
        diedOut = diedOut,
        founded = founded,
        founder = founder,
        heir = heir,
        name = name,
        overlord = overlord,
        region = region,
        seats = seats,
        titles = titles,
        words = words
    )
}

fun List<HouseRes>.toHouse(): List<House>{
    return this.map {
        it.toHouse()
    }
}

fun HouseRes.toDbEntity(): HouseDatabase{
    return HouseDatabase(
        id = 0,
        name = name,
        words = words,
        region = region,
        overlord = overlord,
        heir = overlord,
        founder = founder,
        founded = founded,
        diedOut = diedOut,
        currentLord = currentLord,
        coatOfArms = coatOfArms
    )
}

fun List<HouseRes>.toDbEntity(): List<HouseDatabase>{
    return this.map {
        it.toDbEntity()
    }
}