package ru.skillbranch.gameofthrones.data.local.dagger.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.skillbranch.gameofthrones.data.local.SharedPreferencesHolder
import ru.skillbranch.gameofthrones.data.local.room.AppDatabase
import ru.skillbranch.gameofthrones.data.remote.retrofit.ApiService
import ru.skillbranch.gameofthrones.data.remote.retrofit.RetrofitHolder
import javax.inject.Singleton

@Module
class AppModule(
    private val context: Context,
    private val db: AppDatabase
) {

    @Singleton
    @Provides
    fun getPrefs(): SharedPreferencesHolder = SharedPreferencesHolder(context)

    @Singleton
    @Provides
    fun getContext(): Context = context

    @Singleton
    @Provides
    fun getDatabase(): AppDatabase = db

    @Singleton
    @Provides
    fun getServerApi(c: Context): ApiService = RetrofitHolder(c).getApi()

}