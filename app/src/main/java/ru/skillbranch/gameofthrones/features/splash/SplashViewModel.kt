package ru.skillbranch.gameofthrones.features.splash

import android.accounts.NetworkErrorException
import android.app.Application
import android.util.Log
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.skillbranch.gameofthrones.GameOfThronesApp
import ru.skillbranch.gameofthrones.base.BaseViewModel
import ru.skillbranch.gameofthrones.base.LiveEvent
import ru.skillbranch.gameofthrones.data.remote.retrofit.ApiService
import ru.skillbranch.gameofthrones.repositories.DatabaseRepository
import ru.skillbranch.gameofthrones.utils.Utils
import javax.inject.Inject

class SplashViewModel(app: Application): BaseViewModel(app) {

    @Inject internal lateinit var api: ApiService
    @Inject internal lateinit var databaseRepository: DatabaseRepository

    val networkException = LiveEvent<Unit>()

    val goNextScreen = LiveEvent<Unit>()

    private val TAG = SplashViewModel::class.simpleName

    init {
        GameOfThronesApp.di.getComponent().createViewModelComponent().injectSplashViewModel(this)
        getDataFromServerAndCache()
    }


    private fun getDataFromServerAndCache(){
        databaseRepository.needUpdate()
            .subscribeOn(Schedulers.io())
            //.timeout(5L, TimeUnit.SECONDS)
            .flatMapMaybe {needUpdate ->
                when{
                    needUpdate && Utils.isNetworkAvailable() -> {
                        val housesRequest = api.getAllHouses().flatMapSingle { databaseRepository.insertHouses(it) }
                        val charactersRequest = api.getAllCharacters().flatMapSingle { databaseRepository.insertCharacters(it) }
                        Single.merge(housesRequest, charactersRequest).firstElement()
                    }
                    needUpdate && !Utils.isNetworkAvailable() -> {
                        Maybe.error<Throwable>(NetworkErrorException())
                    }
                    !needUpdate -> {
                        Maybe.empty<Unit>()
                    }
                    else -> {
                        Maybe.error<Throwable>(UnknownError())
                    }
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {
                goNextScreen.call()
            }
            .doOnError {
                if (it is NetworkErrorException)
                    networkException.call()
                else
                    Log.e(TAG, "error", it)
            }
            .subscribe()
    }

}