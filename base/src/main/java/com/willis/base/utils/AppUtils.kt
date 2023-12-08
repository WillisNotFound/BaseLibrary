package com.willis.base.utils

import android.annotation.SuppressLint
import android.content.Context

/**
 * description: APP 工具类
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/8
 */

@SuppressLint("StaticFieldLeak")
lateinit var appContext: Context

fun initAppContext(context: Context) {
    if (::appContext.isInitialized) {
        throw RuntimeException("AppUtils.initAppContext(Context) can only be called once!!!")
    }
    appContext = context.applicationContext
}
