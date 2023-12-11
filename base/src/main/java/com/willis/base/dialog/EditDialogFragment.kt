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
import com.willis.base.R
import com.willis.base.data.BaseResult
import com.willis.base.databinding.DialogEditBinding
import com.willis.base.ext.displayMetrics
import com.willis.base.ext.dp
import com.willis.base.ext.gone
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume

/**
 * description: 编辑弹窗
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/11
 */
internal class EditDialogFragment : DialogFragment() {
    var mBuilder: EditDialogBuilder? = null
    var mContinuation: Continuation<BaseResult<String>>? = null

    private var _binding: DialogEditBinding? = null
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
        _binding = DialogEditBinding.inflate(inflater, container, false)
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
        if (mIsConfirmed == true) {
            val desc = resources.getString(R.string.tips_edit_confirm)
            val value = mBinding.edtContent.text.toString()
            mContinuation?.resume(BaseResult.Success(desc, value))
        } else {
            val desc = resources.getString(R.string.tips_edit_cancel)
            mContinuation?.resume(BaseResult.Failure(desc))
        }
        mContinuation = null
    }

    private fun initView(editDialogBuilder: EditDialogBuilder) {
        mBinding.tvTitle.apply {
            text = editDialogBuilder.title
        }

        mBinding.edtContent.apply {
            setText(editDialogBuilder.content)
        }

        mBinding.btnCancel.apply {
            if (!editDialogBuilder.showCancelButton) gone()
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