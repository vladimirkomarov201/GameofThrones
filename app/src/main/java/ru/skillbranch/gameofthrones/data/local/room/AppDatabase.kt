package ru.skillbranch.gameofthrones.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.skillbranch.gameofthrones.data.local.room.entity.CharacterDatabase
import ru.skillbranch.gameofthrones.data.local.room.entity.HouseDatabase

@Database(entities = [
    CharacterDatabase::class,
    HouseDatabase::class
],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){

}