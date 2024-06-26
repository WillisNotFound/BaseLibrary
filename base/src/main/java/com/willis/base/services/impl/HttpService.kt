package com.willis.base.services.impl

import com.willis.base.services.api.IHttpService
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.util.concurrent.TimeUnit

/**
 * description: IHttpService 实现类
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/12
 */
internal object HttpService : IHttpService {
    private val sOkHttpClient = OkHttpClient.Builder()
        .callTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .build()

    override suspend fun send(request: Request): Response {
        return sOkHttpClient.newCall(request).execute()
    }
}