package ru.skillbranch.gameofthrones.data.local.dagger.components

import android.content.Context
import dagger.Component
import ru.skillbranch.gameofthrones.data.local.dagger.modules.AppModule
import ru.skillbranch.gameofthrones.data.local.dagger.modules.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RepositoryModule::class])
interface AppComponent {
    fun createViewModelComponent(): ViewModelComponent
    fun createRepositoryComponent(): RepositoryComponent
    fun getContext(): Context
}