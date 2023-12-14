package com.willis.base.utils

import com.google.gson.Gson
import com.google.gson.JsonObject

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

    fun fromJson(json: String): JsonObject {
        return gson.fromJson(json, JsonObject::class.java)
    }

    fun toJson(src: Any): String {
        return gson.toJson(src)
    }
}