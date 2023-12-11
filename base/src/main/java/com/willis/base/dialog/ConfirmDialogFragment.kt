package com.willis.base.dialog

import android.app.Dialog
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.Gravity
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.willis.base.databinding.DialogConfirmBinding
import com.willis.base.ext.displayMetrics
import com.willis.base.ext.dp
import com.willis.base.ext.gone
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume

/**
 * description: 确认弹窗
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/11
 */
internal class ConfirmDialogFragment : DialogFragment() {
    var mBuilder: ConfirmDialogBuilder? = null
    var mContinuation: Continuation<Boolean?>? = null

    private var _binding: DialogConfirmBinding? = null
    private val mBinding get() = _binding!!

    private var mIsConfirmed: Boolean? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            mBuilder?.let {
                setCancelable(it.isCanceledOnBackPress)
                setCanceledOnTouchOutside(it.isCanceledOnTouchOutside)
                if (!it.isCanceledOnBackPress) setOnKeyListener { _, keyCode, _ -> keyCode == KeyEvent.KEYCODE_BACK }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DialogConfirmBinding.inflate(inflater, container, false)
        mBuilder?.let { initView(it) }
        initListener()
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.run {
            setGravity(Gravity.CENTER)
            setBackgroundDrawableResource(android.R.color.transparent)
            attributes = attributes?.apply {
                width = displayMetrics.widthPixels - 84.dp
                height = WindowManager.LayoutParams.WRAP_CONTENT
                dimAmount = 0.4F
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mContinuation?.resume(mIsConfirmed)
        mContinuation = null
    }

    private fun initView(confirmDialogBuilder: ConfirmDialogBuilder) {
        mBinding.tvTitle.apply {
            text = confirmDialogBuilder.title
        }

        mBinding.tvContent.apply {
            text = confirmDialogBuilder.content
            movementMethod = ScrollingMovementMethod()
        }

        mBinding.btnCancel.apply {
            if (!confirmDialogBuilder.showCancelButton) gone()
        }
    }

    private fun initListener() {
        mBinding.btnCancel.setOnClickListener {
            mIsConfirmed = false
            dismissAllowingStateLoss()
        }

        mBinding.btnConfirm.setOnClickListener {
            mIsConfirmed = true
            dismissAllowingStateLoss()
        }
    }
}