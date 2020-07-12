package ru.skillbranch.gameofthrones.data.remote.retrofit

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.skillbranch.gameofthrones.GameOfThronesApp
import ru.skillbranch.gameofthrones.R
import ru.skillbranch.gameofthrones.data.errors.DataLayerError
import ru.skillbranch.gameofthrones.data.errors.implementations.CommonError
import ru.skillbranch.gameofthrones.data.errors.implementations.CommonServerError
import java.net.ConnectException
import java.net.SocketTimeoutException

/**
 * Колбек для обработки общих ошибок
 */

open class CustomCallback<T>(
    private val onSuccess: (T) -> Unit,
    private val onError: (DataLayerError) -> Unit
) : Callback<T> {

    private val TAG = CustomCallback::class.simpleName

    override fun onFailure(call: Call<T>, t: Throwable) {
        Log.e(TAG,"ERROR" , t)
        if (call.isCanceled) {
            //если запрос сброшен ничего не делаем
            return
        }

        val context = GameOfThronesApp.di.getComponent().getContext()

        val message = when (t) {
            is ConnectException -> context.getString(R.string.network_error)
            is SocketTimeoutException -> context.getString(R.string.server_timeout)
            else -> context.getString(R.string.unknown_error)
        }

        onError.invoke(CommonError(
            message = message,
            throwable = t
        ))
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {

        if (response.isSuccessful) {
            val body = response.body()
            response.body()

            if (body == null) {
                Log.e(TAG, "response ${call.request().url} is null")
                onError.invoke(CommonError(throwable = NullPointerException()))
            } else {
                onSuccess.invoke(body)
            }

            return
        }

        onError.invoke(CommonServerError(httpCode = response.code()))

    }

}








