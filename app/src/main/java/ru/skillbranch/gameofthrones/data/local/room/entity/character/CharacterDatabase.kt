package ru.skillbranch.gameofthrones.data.local.room.entity.character

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterDatabase(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val gender: String,
    val culture: String,
    val born: String,
    val died: String,
    val father: String,
    val mother: String,
    val spouse: String,
    @ColumnInfo(name = "house_id")
    val houseId: String
)