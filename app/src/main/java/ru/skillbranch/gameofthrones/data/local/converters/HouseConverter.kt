package ru.skillbranch.gameofthrones.data.local.converters

import ru.skillbranch.gameofthrones.data.local.entities.House
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

fun HouseRes.toHouse(): House{
    return House(
        id = "0",
        ancestralWeapons = this.ancestralWeapons,
        coatOfArms = this.coatOfArms,
        currentLord = this.currentLord,
        diedOut = this.diedOut,
        founded = this.founded,
        founder = this.founder,
        heir = this.heir,
        name = this.name,
        overlord = this.overlord,
        region = region,
        seats = seats,
        titles = titles,
        words = words
    )
}