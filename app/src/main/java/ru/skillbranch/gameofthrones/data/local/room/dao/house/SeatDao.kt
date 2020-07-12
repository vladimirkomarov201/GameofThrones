package ru.skillbranch.gameofthrones.data.local.room.dao.house

import androidx.room.Query
import io.reactivex.Maybe
import ru.skillbranch.gameofthrones.data.local.room.dao.BaseDao
import ru.skillbranch.gameofthrones.data.local.room.entity.house.Seat

interface SeatDao: BaseDao<Seat> {

    @Query("SELECT * FROM seats WHERE house_id = :houseId")
    fun getAllByHouseId(houseId: Long): Maybe<List<Seat>>

}