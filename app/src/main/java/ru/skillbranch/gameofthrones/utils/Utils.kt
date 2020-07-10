package ru.skillbranch.gameofthrones.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import ru.skillbranch.gameofthrones.GameOfThronesApp

object Utils {

    fun copyTextToClipboard(text: String) {
        val context = GameOfThronesApp.di.getComponent().getContext()
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager? ?: return
        val clip = ClipData.newPlainText(Utils::class.simpleName, text)
        clipboard.setPrimaryClip(clip)
    }

    fun isNetworkAvailable(): Boolean{
        val context = GameOfThronesApp.di.getComponent().getContext()
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager? ?: return false
        val activeNetwork = cm.activeNetwork ?: return false
        val nc = cm.getNetworkCapabilities(activeNetwork) ?: return false
        return (nc.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI))
    }

}