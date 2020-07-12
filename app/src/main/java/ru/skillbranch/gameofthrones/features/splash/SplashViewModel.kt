package ru.skillbranch.gameofthrones.features.splash

import android.app.Application
import ru.skillbranch.gameofthrones.base.BaseViewModel
import ru.skillbranch.gameofthrones.repositories.RootRepository

class SplashViewModel(app: Application): BaseViewModel(app) {

    init {
        RootRepository.getAllHouses(
            result = {
                textEvent.value = "success"
            }
        )
    }

}