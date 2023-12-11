package com.willis.base.data

/**
 * description: none
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/11
 */
sealed class BaseResult<out T> {
    /**
     * 具体描述
     */
    abstract val desc: String

    class Success<T>(override val desc: String, val value: T) : BaseResult<T>()

    class Failure<T>(override val desc: String) : BaseResult<T>() {
        val value: T? = null
    }
}