package ru.skillbranch.gameofthrones.data.errors

import android.content.Context

interface DataLayerError {
    fun getMessage(context: Context): String
    fun getThrowable(): Throwable
}