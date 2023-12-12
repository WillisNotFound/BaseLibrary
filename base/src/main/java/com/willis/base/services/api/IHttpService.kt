package com.willis.base.services.api

import okhttp3.Request
import okhttp3.Response

/**
 * description: HTTP 服务
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/12
 */
interface IHttpService {
    /**
     * 发送HTTP请求获取响应
     */
    suspend fun send(request: Request): Response
}