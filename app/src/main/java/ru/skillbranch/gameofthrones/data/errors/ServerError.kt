package ru.skillbranch.gameofthrones.data.errors

interface ServerError: DataLayerError {
    fun getHttpCode(): Int
}