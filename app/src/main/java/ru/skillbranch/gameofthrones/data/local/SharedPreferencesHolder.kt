package ru.skillbranch.gameofthrones.data.local

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHolder(context: Context) {

    private val mSettings: SharedPreferences = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)

    fun putString(KEY: String, value: String?){
        val editor = mSettings.edit()
        editor.putString(KEY, value)
        editor.apply()
    }

    fun getString(KEY: String, value: String) = mSettings.getString(KEY, value) ?: ""

    fun putBoolean(KEY: String, value: Boolean){
        val editor = mSettings.edit()
        editor.putBoolean(KEY, value)
        editor.apply()
    }
    fun getBoolean(KEY: String, value: Boolean)= mSettings.getBoolean(KEY, value)

    fun putInt(KEY: String, value: Int){
        val editor = mSettings.edit()
        editor.putInt(KEY, value)
        editor.apply()
    }

    fun getInt(KEY: String, value: Int) = mSettings.getInt(KEY, value)

    fun removeValue(KEY: String) {
        val editor = mSettings.edit()
        editor?.remove(KEY)
        editor?.apply()
    }

    companion object {
        private const val APP_PREFERENCES = "MySettings"
    }
}