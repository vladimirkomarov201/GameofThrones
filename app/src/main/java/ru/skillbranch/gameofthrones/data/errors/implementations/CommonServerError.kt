package ru.skillbranch.gameofthrones.data.errors.implementations

import android.content.Context
import ru.skillbranch.gameofthrones.R
import ru.skillbranch.gameofthrones.data.errors.ServerError

class CommonServerError(
    private val message: String? = null,
    private val throwable: Throwable = Exception(),
    private val httpCode: Int
): ServerError {
    override fun getMessage(context: Context): String = message ?: context.getString(R.string.unknown_error)
    override fun getThrowable(): Throwable = throwable
    override fun getHttpCode(): Int = httpCode
}