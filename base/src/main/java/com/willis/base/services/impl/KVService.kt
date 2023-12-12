package com.willis.base.services.impl

import com.tencent.mmkv.MMKV
import com.willis.base.services.api.IKVService
import com.willis.base.utils.AppUtils.appContext

/**
 * description: IKVService 实现类
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/12
 */
object KVService : IKVService {
    private val sMMKV by lazy {
        MMKV.initialize(appContext)
        MMKV.defaultMMKV()
    }

    override fun putBoolean(key: String, value: Boolean): Boolean {
        return sMMKV.encode(key, value)
    }

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return sMMKV.decodeBool(key, defaultValue)
    }

    override fun putInt(key: String, value: Int): Boolean {
        return sMMKV.encode(key, value)
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        return sMMKV.decodeInt(key, defaultValue)
    }

    override fun putLong(key: String, value: Long): Boolean {
        return sMMKV.encode(key, value)
    }

    override fun getLong(key: String, defaultValue: Long): Long {
        return sMMKV.decodeLong(key, defaultValue)
    }

    override fun putFloat(key: String, value: Float): Boolean {
        return sMMKV.encode(key, value)
    }

    override fun getFloat(key: String, defaultValue: Float): Float {
        return sMMKV.decodeFloat(key, defaultValue)
    }

    override fun putDouble(key: String, value: Double): Boolean {
        return sMMKV.encode(key, value)
    }

    override fun getDouble(key: String, defaultValue: Double): Double {
        return sMMKV.decodeDouble(key, defaultValue)
    }

    override fun putString(key: String, value: String?): Boolean {
        return sMMKV.encode(key, value)
    }

    override fun getString(key: String, defaultValue: String?): String? {
        return sMMKV.decodeString(key, defaultValue)
    }
}