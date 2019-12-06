package com.sevenpeakssoftware.yogendra_b.utilities

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo


/** The base URL of the API */
const val BASE_URL: String = "https://www.apphusetreach.no/application/119267/"
const val GET_ARTICALS_ENDPOINT: String = "article/get_articles_list"


fun getConnectionStatus(context: Context): Boolean {
    val mConnectivityManager: ConnectivityManager
    val mNetworkInfoMobile: NetworkInfo
    val mNetworkInfoWifi: NetworkInfo
    mConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    mNetworkInfoMobile = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
    mNetworkInfoWifi = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
    try {
        if (mNetworkInfoMobile.isConnected) {
            return true
        }
    } catch (exception: Exception) { // exception.printStackTrace();
    }
    return mNetworkInfoWifi.isConnected
}