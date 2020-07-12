package ru.skillbranch.gameofthrones.data.local.room.dao.character

import androidx.room.Query
import io.reactivex.Maybe
import ru.skillbranch.gameofthrones.data.local.room.dao.BaseDao
import ru.skillbranch.gameofthrones.data.local.room.entity.character.CharacterTitle

interface CharacterTitleDao: BaseDao<CharacterTitle> {

    @Query("SELECT * FROM character_titles WHERE character_id = :characterId")
    fun getAllByCharacterId(characterId: Long): Maybe<List<CharacterTitle>>

}