package com.willis.base.ext

import android.text.Editable
import android.text.TextWatcher
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.willis.base.utils.AppUtils.appContext

/**
 * description: View 扩展函数
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/11
 */

fun <T : View> T.gone() {
    visibility = View.GONE
}

fun <T : View> T.visible() {
    visibility = View.VISIBLE
}

fun <T : View> T.isVisible(): Boolean {
    return visibility == View.VISIBLE
}

fun View.setWidthHeight(width: Int, height: Int) {
    layoutParams = ViewGroup.LayoutParams(width, height)
}


val displayMetrics: DisplayMetrics by lazy { appContext.resources.displayMetrics }

val Int.dp: Int get() = (this * displayMetrics.density).toInt()

val Float.dp: Int get() = (this * displayMetrics.density).toInt()

val Int.dpf: Float get() = (this * displayMetrics.density)

val Float.dpf: Float get() = (this * displayMetrics.density)

val Float.sp2px: Float get() = this * displayMetrics.scaledDensity + 0.5f

inline fun EditText.addOnTextChangeListener(crossinline onTextChange: (CharSequence?) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            onTextChange(s)
        }

        override fun afterTextChanged(s: Editable?) {}

    })
}