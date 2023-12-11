package com.willis.base.services

import com.willis.base.services.api.IDialogService
import com.willis.base.services.impl.DialogService


/**
 * 弹窗服务
 */
val dialogService: IDialogService get() = DialogService