package ru.skillbranch.gameofthrones.data.local.dagger.components

import dagger.Subcomponent
import ru.skillbranch.gameofthrones.features.splash.SplashViewModel

@Subcomponent
interface ViewModelComponent {
    fun injectSplashViewModel(viewModel: SplashViewModel)
}