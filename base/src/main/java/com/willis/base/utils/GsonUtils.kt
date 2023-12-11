package com.willis.base.utils

import com.google.gson.Gson

/**
 * description: Gson 工具类
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/11
 */
object GsonUtils {
    private val gson = Gson()

    fun <T> fromJson(json: String, classOfT: Class<T>): T {
        return gson.fromJson(json, classOfT)
    }

    fun toJson(src: Any): String {
        return gson.toJson(src)
    }
}