package com.willis.baselibrary

import android.app.Application
import com.willis.base.installBaseLibrary

/**
 * description: none
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/11
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        installBaseLibrary(this)
    }
}