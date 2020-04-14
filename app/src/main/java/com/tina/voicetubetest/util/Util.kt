package com.tina.voicetubetest.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.tina.voicetubetest.VoiceTubeApplication

object Util {

    fun isInternetConnected(): Boolean {
        val cm = VoiceTubeApplication.INSTANCE
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }

    fun getString(resourceId: Int): String {
        return VoiceTubeApplication.INSTANCE.getString(resourceId)
    }

}