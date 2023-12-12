package com.willis.base.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

/**
 * description: 网络工具类
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/12
 */
object NetworkUtils {
    /**
     * 判断网络是否可用
     */
    fun isNetworkUsable(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = manager.getNetworkCapabilities(manager.activeNetwork)
        if (networkCapabilities != null) {
            return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        }
        return false
    }
}