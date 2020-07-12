package ru.skillbranch.gameofthrones.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface BaseDao<T> {

    @Insert
    fun insert(item: T): Single<Long>

    @Insert
    fun insert(items: List<T>): Single<Long>

    @Delete
    fun delete(item: T): Single<Int>

    @Delete
    fun delete(items: List<T>): Single<Int>

    @Query("SELECT * FROM characters WHERE id = :id")
    fun getById(id: Long): Maybe<T>

    @Query("SELECT * FROM characters")
    fun getAll(): Maybe<List<T>>

}