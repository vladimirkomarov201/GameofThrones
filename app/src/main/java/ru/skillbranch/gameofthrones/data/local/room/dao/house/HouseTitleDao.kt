package ru.skillbranch.gameofthrones.data.local.room.dao.house

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Maybe
import ru.skillbranch.gameofthrones.data.local.room.dao.BaseDao
import ru.skillbranch.gameofthrones.data.local.room.entity.house.HouseTitle

@Dao
interface HouseTitleDao: BaseDao<HouseTitle> {

    @Query("SELECT * FROM house_titles WHERE house_id = :houseId")
    fun getAllByHouseId(houseId: Long): Maybe<List<HouseTitle>>

}