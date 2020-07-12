package ru.skillbranch.gameofthrones.data.remote.retrofit

import android.util.Log
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import ru.skillbranch.gameofthrones.GameOfThronesApp
import ru.skillbranch.gameofthrones.R
import ru.skillbranch.gameofthrones.data.errors.DataLayerError
import ru.skillbranch.gameofthrones.data.errors.implementations.CommonError
import ru.skillbranch.gameofthrones.data.errors.implementations.CommonServerError
import java.net.ConnectException
import java.net.SocketTimeoutException

class ServerErrorSubscriber<T>(
    private val onSuccess: (T) -> Unit,
    private val onError: (DataLayerError) -> Unit
): Observer<T> {

    private val TAG = ServerErrorSubscriber::class.simpleName

    override fun onComplete() {}

    override fun onSubscribe(d: Disposable) {}

    override fun onNext(result: T) {
        if (result == null) {
            Log.e(TAG, "response is null")
            onError.invoke(CommonError(throwable = NullPointerException()))
        } else {
            onSuccess.invoke(result)
        }
    }

    override fun onError(t: Throwable) {
        Log.e(TAG,"ERROR" , t)
        val context = GameOfThronesApp.di.getComponent().getContext()
        val message = when (t) {
            is ConnectException -> context.getString(R.string.network_error)
            is SocketTimeoutException -> context.getString(R.string.server_timeout)
            else -> context.getString(R.string.unknown_error)
        }
        if (t is HttpException)
            onError.invoke(
                CommonServerError(
                    message = message,
                    throwable = t,
                    httpCode = t.code()
                )
            )
        else
            onError.invoke(
                CommonError(
                    message = message,
                    throwable = t
                )
            )
    }

}