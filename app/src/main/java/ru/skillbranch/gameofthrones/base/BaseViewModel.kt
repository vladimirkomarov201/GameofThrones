package ru.skillbranch.gameofthrones.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

abstract class BaseViewModel(
    app: Application
): AndroidViewModel(app) {

    val textEvent = LiveEvent<String>()
    val showLoading = MutableLiveData<Boolean>()

}