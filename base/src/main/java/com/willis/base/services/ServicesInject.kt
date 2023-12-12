package com.willis.base.services

import com.willis.base.services.api.IDialogService
import com.willis.base.services.api.IHttpService
import com.willis.base.services.api.IKVService
import com.willis.base.services.api.IToastService
import com.willis.base.services.impl.DialogService
import com.willis.base.services.impl.HttpService
import com.willis.base.services.impl.KVService
import com.willis.base.services.impl.ToastService


/**
 * 弹窗服务
 */
val dialogService: IDialogService get() = DialogService

/**
 * Toast 服务
 */
val toastService: IToastService get() = ToastService

/**
 * HTTP 服务
 */
val httpService: IHttpService get() = HttpService

/**
 * Key-Value 服务
 */
val kvService: IKVService get() = KVService