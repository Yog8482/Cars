package com.sevenpeakssoftware.yogendra_b.utilities

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build


/** The base URL of the API */
const val BASE_URL: String = "https://www.apphusetreach.no/application/119267/"
const val GET_ARTICALS_ENDPOINT: String = "article/get_articles_list"


fun getConnectionStatus(context: Context): Boolean {

    val cm =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    if (Build.VERSION.SDK_INT < 23) {
        val ni = cm.activeNetworkInfo
        if (ni != null) {
            return ni.isConnected && (ni.type == ConnectivityManager.TYPE_WIFI || ni.type == ConnectivityManager.TYPE_MOBILE)
        }
    } else {
        val n: Network? = cm.activeNetwork
        if (n != null) {
            val nc = cm.getNetworkCapabilities(n)
            return nc!!.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || nc.hasTransport(
                NetworkCapabilities.TRANSPORT_WIFI
            )
        }
    }

    return false


}