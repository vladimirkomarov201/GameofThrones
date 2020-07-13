package ru.skillbranch.gameofthrones.data.local.room.dao.character

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Maybe
import ru.skillbranch.gameofthrones.data.local.room.dao.BaseDao
import ru.skillbranch.gameofthrones.data.local.room.entity.character.CharacterDatabase

@Dao
interface CharacterDao: BaseDao<CharacterDatabase>{

    @Query("SELECT * FROM characters WHERE id = :id")
    fun getById(id: Long): Maybe<CharacterDatabase>

    @Query("SELECT * FROM characters")
    fun getAll(): Maybe<List<CharacterDatabase>>

}