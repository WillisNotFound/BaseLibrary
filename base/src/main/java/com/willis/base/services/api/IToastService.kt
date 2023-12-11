package com.willis.base.services.api

import android.widget.Toast

/**
 * description: Toast 服务
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/11
 */
interface IToastService {
    /**
     * 弹出Toast（普通背景）
     */
    fun showNormal(content: String, duration: Int = Toast.LENGTH_SHORT)

    /**
     * 弹出Toast（正确背景）
     */
    fun showRight(content: String, duration: Int = Toast.LENGTH_SHORT)

    /**
     * 弹出Toast（错误背景）
     */
    fun showError(content: String, duration: Int = Toast.LENGTH_LONG)
}