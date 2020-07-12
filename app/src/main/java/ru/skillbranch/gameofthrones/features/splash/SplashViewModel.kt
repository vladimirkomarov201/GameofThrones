package ru.skillbranch.gameofthrones.features.splash

import android.app.Application
import ru.skillbranch.gameofthrones.GameOfThronesApp
import ru.skillbranch.gameofthrones.base.BaseViewModel
import ru.skillbranch.gameofthrones.data.remote.retrofit.ApiService
import javax.inject.Inject

class SplashViewModel(app: Application): BaseViewModel(app) {

    @Inject internal lateinit var api: ApiService

    init {
        GameOfThronesApp.di.getComponent().createViewModelComponent().injectSplashViewModel(this)
    }

    private fun getDataFromServerAndCache(){

    }

}