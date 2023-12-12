package com.willis.base.utils

import android.content.Context
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.willis.base.utils.AppUtils.appContext

/**
 * description: 键盘工具类
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/11
 */
object KeyboardUtils {
    private val inputMethodManager get() = appContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    /**
     * 是否需要隐藏键盘
     */
    fun shouldHideKeyboard(currentFocusView: View, ev: MotionEvent): Boolean {
        if (ev.action != MotionEvent.ACTION_DOWN) return false
        val l = intArrayOf(0, 0)
        currentFocusView.getLocationInWindow(l)
        val left = l[0]
        val top = l[1]
        val bottom: Int = top + currentFocusView.height
        val right: Int = left + currentFocusView.width
        return !(ev.x > left && ev.x < right && ev.y > top && ev.y < bottom)
    }

    /**
     * 隐藏键盘
     */
    fun hideKeyboard() {
        ActivityUtils.currentActivity?.window?.decorView?.windowToken?.let {
            inputMethodManager.hideSoftInputFromWindow(it, 0)
        }
    }

    /**
     * 弹出键盘
     */
    fun showKeyboard(view: View) {
        view.isFocusable = true
        if (view.requestFocus()) inputMethodManager.showSoftInput(view, 0)
    }
}