package com.willis.base

import android.app.Application
import com.willis.base.utils.ActivityUtils
import com.willis.base.utils.AppUtils

/**
 * Application#onCreate()时调用
 */
fun installBaseLibrary(application: Application) {
    AppUtils.init(application)
    ActivityUtils.init(application)
}