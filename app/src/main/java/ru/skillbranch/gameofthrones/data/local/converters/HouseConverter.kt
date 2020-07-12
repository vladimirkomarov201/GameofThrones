package ru.skillbranch.gameofthrones.data.local.converters

import ru.skillbranch.gameofthrones.data.local.entities.House
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