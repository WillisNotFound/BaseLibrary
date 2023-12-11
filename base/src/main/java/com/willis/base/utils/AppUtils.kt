package com.willis.base.utils

import android.annotation.SuppressLint
import android.content.Context

/**
 * description: APP 工具类
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/8
 */

object AppUtils {
    @SuppressLint("StaticFieldLeak")
    lateinit var appContext: Context

    fun init(context: Context) {
        if (::appContext.isInitialized) {
            throw RuntimeException("AppUtils.init(Context) can only be called once!!!")
        }
        appContext = context.applicationContext
    }
}