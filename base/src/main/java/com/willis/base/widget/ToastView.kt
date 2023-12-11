package com.willis.base.widget

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.ContextCompat.getSystemService
import com.willis.base.R

/**
 * description: none
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/11
 */
class ToastView(context: Context) : FrameLayout(context) {
    init {
        val layoutInflater = getSystemService(context, LayoutInflater::class.java)
        layoutInflater!!.inflate(R.layout.layout_toast_view, this)
    }
}