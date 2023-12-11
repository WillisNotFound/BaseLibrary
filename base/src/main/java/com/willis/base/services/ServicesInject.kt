package com.willis.base.services

import com.willis.base.services.api.IDialogService
import com.willis.base.services.api.IToastService
import com.willis.base.services.impl.DialogService
import com.willis.base.services.impl.ToastService


/**
 * 弹窗服务
 */
val dialogService: IDialogService get() = DialogService

/**
 * Toast服务
 */
val toastService: IToastService get() = ToastService