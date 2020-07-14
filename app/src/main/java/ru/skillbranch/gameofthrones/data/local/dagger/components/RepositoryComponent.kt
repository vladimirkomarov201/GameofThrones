package ru.skillbranch.gameofthrones.data.local.dagger.components

import dagger.Subcomponent
import ru.skillbranch.gameofthrones.repositories.DatabaseRepository

@Subcomponent
interface RepositoryComponent {

    fun getDatabaseRepository(): DatabaseRepository

}