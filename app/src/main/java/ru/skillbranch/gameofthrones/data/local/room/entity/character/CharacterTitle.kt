package ru.skillbranch.gameofthrones.data.local.room.entity.character

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "character_titles",
    foreignKeys = [
        ForeignKey(
            entity = CharacterDatabase::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("character_id"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CharacterTitle(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "character_id")
    val characterId: Long,
    val value: String
)