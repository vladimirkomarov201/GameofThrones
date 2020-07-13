package ru.skillbranch.gameofthrones.data.local.room.dao.character

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Maybe
import ru.skillbranch.gameofthrones.data.local.room.dao.BaseDao
import ru.skillbranch.gameofthrones.data.local.room.entity.character.Alias

@Dao
interface AliasDao: BaseDao<Alias> {

    @Query("SELECT * FROM aliases WHERE character_id = :characterId")
    fun getAllByCharacterId(characterId: Long): Maybe<List<Alias>>

}