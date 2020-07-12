package ru.skillbranch.gameofthrones.data.local.room.entity.house

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "seats",
    foreignKeys = [
        ForeignKey(
            entity = HouseDatabase::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("house_id"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Seat(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "house_id")
    val houseId: Long,
    val value: String
)