package ru.skillbranch.gameofthrones.data.local.room.entity.house

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "houses"
)
data class HouseDatabase(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val region: String,
    @ColumnInfo(name = "coat_of_arms")
    val coatOfArms: String,
    val words: String,
    @ColumnInfo(name = "current_lord")
    val currentLord: String,
    val heir: String,
    val overlord: String,
    val founded: String,
    val founder: String,
    @ColumnInfo(name = "died_out")
    val diedOut: String
)