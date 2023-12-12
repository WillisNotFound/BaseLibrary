package com.willis.base.services.api

/**
 * description: Key-Value 服务
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/12
 */
interface IKVService {
    fun putBoolean(key: String, value: Boolean): Boolean

    fun getBoolean(key: String, defaultValue: Boolean): Boolean

    fun putInt(key: String, value: Int): Boolean

    fun getInt(key: String, defaultValue: Int): Int

    fun putLong(key: String, value: Long): Boolean

    fun getLong(key: String, defaultValue: Long): Long

    fun putFloat(key: String, value: Float): Boolean

    fun getFloat(key: String, defaultValue: Float): Float

    fun putDouble(key: String, value: Double): Boolean

    fun getDouble(key: String, defaultValue: Double): Double

    fun putString(key: String, value: String?): Boolean

    fun getString(key: String, defaultValue: String? = null): String?
}