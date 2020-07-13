package ru.skillbranch.gameofthrones.data.local.room.dao.house

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Maybe
import ru.skillbranch.gameofthrones.data.local.room.dao.BaseDao
import ru.skillbranch.gameofthrones.data.local.room.entity.house.AncestralWeapon

@Dao
interface AncestralWeaponDao: BaseDao<AncestralWeapon> {

    @Query("SELECT * FROM ancestral_weapons WHERE house_id = :houseId")
    fun getAllByHouseId(houseId: Long): Maybe<List<AncestralWeapon>>

}