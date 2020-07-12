package ru.skillbranch.gameofthrones.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.skillbranch.gameofthrones.data.local.room.dao.character.AliasDao
import ru.skillbranch.gameofthrones.data.local.room.dao.character.CharacterDao
import ru.skillbranch.gameofthrones.data.local.room.dao.character.CharacterTitleDao
import ru.skillbranch.gameofthrones.data.local.room.dao.house.AncestralWeaponDao
import ru.skillbranch.gameofthrones.data.local.room.dao.house.HouseDao
import ru.skillbranch.gameofthrones.data.local.room.dao.house.HouseTitleDao
import ru.skillbranch.gameofthrones.data.local.room.dao.house.SeatDao
import ru.skillbranch.gameofthrones.data.local.room.entity.character.Alias
import ru.skillbranch.gameofthrones.data.local.room.entity.character.CharacterDatabase
import ru.skillbranch.gameofthrones.data.local.room.entity.character.CharacterTitle
import ru.skillbranch.gameofthrones.data.local.room.entity.house.AncestralWeapon
import ru.skillbranch.gameofthrones.data.local.room.entity.house.HouseDatabase
import ru.skillbranch.gameofthrones.data.local.room.entity.house.HouseTitle
import ru.skillbranch.gameofthrones.data.local.room.entity.house.Seat

@Database(entities = [
    CharacterDatabase::class,
    HouseDatabase::class,
    Alias::class,
    CharacterTitle::class,
    AncestralWeapon::class,
    HouseTitle::class,
    Seat::class
],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun getAliasDao(): AliasDao
    abstract fun getCharacterDao(): CharacterDao
    abstract fun getCharacterTitleDao(): CharacterTitleDao
    abstract fun getAncestralWeaponDao(): AncestralWeaponDao
    abstract fun getHouseDao(): HouseDao
    abstract fun getHouseTitleDao(): HouseTitleDao
    abstract fun getSeatDao(): SeatDao
}