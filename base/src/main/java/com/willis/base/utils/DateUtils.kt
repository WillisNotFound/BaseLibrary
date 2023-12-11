package com.willis.base.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * description: 日期工具类
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/11
 */
object DateUtils {
    private const val DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss"

    /**
     * 格式化时间
     */
    fun getFormatTime(timeMillis: Long, pattern: String = DEFAULT_PATTERN): String {
        val simpleDateFormat = SimpleDateFormat(pattern, Locale.CHINA)
        return simpleDateFormat.format(Date(timeMillis))
    }

    /**
     * 1970.01.01 00:00:00 至今的毫秒数
     */
    fun currentMillis() = System.currentTimeMillis()
}