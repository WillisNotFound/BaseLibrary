package com.willis.base.services.impl

import android.graphics.Color
import android.graphics.Typeface
import android.os.Looper
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import android.widget.Toast
import com.willis.base.ext.dp
import com.willis.base.ext.dpf
import com.willis.base.ext.setWidthHeight
import com.willis.base.services.api.IToastService
import com.willis.base.utils.ActivityUtils
import com.willis.base.utils.AppUtils.appContext
import com.willis.base.utils.ShapeUtils

/**
 * description: IToastService 实现类
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/11
 */
internal object ToastService : IToastService {
    private const val COLOR_NORMAL: Long = 0xFF848896
    private const val COLOR_RIGHT: Long = 0xFF52B45E
    private const val COLOR_ERROR: Long = 0xFFFF4D4D

    private val sToast = Toast(appContext).apply {
        view = TextView(appContext).apply {
            setWidthHeight(WRAP_CONTENT, WRAP_CONTENT)
            setPadding(24.dp, 12.dp, 24.dp, 12.dp)
            background = ShapeUtils.buildCustomShape(24.dpf).apply { alpha = 200 }
            setTextColor(Color.WHITE)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 14F)
            gravity = Gravity.CENTER
            typeface = Typeface.create("sans-serif", Typeface.NORMAL)
        }
    }

    override fun showNormal(content: String, duration: Int) {
        show(content, COLOR_NORMAL, duration)
    }

    override fun showRight(content: String, duration: Int) {
        show(content, COLOR_RIGHT, duration)
    }

    override fun showError(content: String, duration: Int) {
        show(content, COLOR_ERROR, duration)
    }

    private fun show(content: String, backgroundColor: Long, duration: Int) {
        val block = {
            (sToast.view as? TextView)?.let {
                it.text = content
                it.background.setTint(backgroundColor.toInt())
            }
            sToast.duration = duration
            sToast.show()
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ActivityUtils.currentActivity?.runOnUiThread { block() }
        } else {
            block()
        }
    }
}