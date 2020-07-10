package ru.skillbranch.gameofthrones.data.local.dagger

import ru.skillbranch.gameofthrones.data.local.dagger.components.AppComponent

/**
 * обертка для компонента даггера
 */

class DI(private val component: AppComponent) {
    fun getComponent(): AppComponent = component
}