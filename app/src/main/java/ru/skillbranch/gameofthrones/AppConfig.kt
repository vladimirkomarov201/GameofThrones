package ru.skillbranch.gameofthrones

object AppConfig {
    const val RETROFIT_CONNECTION_TIMEOUT_SEC = 20L
    val NEED_HOUSES = arrayOf(
        "House Stark of Winterfell",
        "House Lannister of Casterly Rock",
        "House Targaryen of King's Landing",
        "House Greyjoy of Pyke",
        "House Tyrell of Highgarden",
        "House Baratheon of Dragonstone",
        "House Nymeros Martell of Sunspear"
    )
    const val BASE_URL = "https://www.anapioficeandfire.com/api/"
}