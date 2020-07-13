package ru.skillbranch.gameofthrones.data.local.room.dao

import androidx.room.Delete
import androidx.room.Insert
import io.reactivex.Single

interface BaseDao<T> {

    @Insert
    fun insert(item: T): Single<Long>

    @Insert
    fun insert(items: List<T>): Single<List<Long>>

    @Delete
    fun delete(item: T): Single<Int>

    @Delete
    fun delete(items: List<T>): Single<Int>

}