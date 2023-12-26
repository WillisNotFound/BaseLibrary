package com.willis.base.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources

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

    fun getString(stringId: Int): String {
        val result = try {
            appContext.resources.getString(stringId)
        } catch (e: Resources.NotFoundException) {
            "null"
        }
        return result
    }

    fun getString(stringId: Int, vararg params: Any): String {
        val result = try {
            appContext.resources.getString(stringId, params)
        } catch (e: Resources.NotFoundException) {
            "null"
        }
        return result
    }
}