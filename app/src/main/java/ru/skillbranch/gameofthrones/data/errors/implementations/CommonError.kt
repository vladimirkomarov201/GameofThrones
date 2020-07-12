package ru.skillbranch.gameofthrones.data.errors.implementations

import android.content.Context
import ru.skillbranch.gameofthrones.R
import ru.skillbranch.gameofthrones.data.errors.DataLayerError

class CommonError(
    private val message: String? = null,
    private val throwable: Throwable = Exception()
): DataLayerError {
    override fun getMessage(context: Context): String = message ?: context.getString(R.string.unknown_error)
    override fun getThrowable(): Throwable = throwable
}