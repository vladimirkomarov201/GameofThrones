package ru.skillbranch.gameofthrones

import android.app.Application
import androidx.room.Room
import ru.skillbranch.gameofthrones.data.local.dagger.DI
import ru.skillbranch.gameofthrones.data.local.dagger.components.DaggerAppComponent
import ru.skillbranch.gameofthrones.data.local.dagger.modules.AppModule
import ru.skillbranch.gameofthrones.data.local.room.AppDatabase

class GameOfThronesApp: Application() {

    override fun onCreate() {
        super.onCreate()
        val component = DaggerAppComponent.builder().appModule(
            AppModule(
                context = applicationContext,
                db = buildDatabase()
            )
        ).build()
        di = DI(component)
    }

    private fun buildDatabase(): AppDatabase{
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app_database"
        ).build()
    }

    companion object{
        lateinit var di: DI
    }

}