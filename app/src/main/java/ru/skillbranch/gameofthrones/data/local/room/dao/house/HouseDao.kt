package ru.skillbranch.gameofthrones.data.local.room.dao.house

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Maybe
import ru.skillbranch.gameofthrones.data.local.room.dao.BaseDao
import ru.skillbranch.gameofthrones.data.local.room.entity.house.HouseDatabase

@Dao
interface HouseDao: BaseDao<HouseDatabase>{

    @Query("SELECT * FROM houses WHERE id = :id")
    fun getById(id: Long): Maybe<HouseDatabase>

    @Query("SELECT * FROM houses")
    fun getAll(): Maybe<List<HouseDatabase>>

}