package ru.skillbranch.gameofthrones.data.local.dagger.modules

import dagger.Module
import dagger.Provides
import ru.skillbranch.gameofthrones.data.local.room.AppDatabase
import ru.skillbranch.gameofthrones.repositories.DatabaseRepository
import ru.skillbranch.gameofthrones.repositories.impls.RoomDatabaseRepository

@Module
class RepositoryModule {

    @Provides
    fun getDatabaseRepository(db: AppDatabase): DatabaseRepository = RoomDatabaseRepository(db)

}