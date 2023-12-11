package com.willis.base.services.impl

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.willis.base.data.BaseResult
import com.willis.base.dialog.ConfirmDialogBuilder
import com.willis.base.dialog.ConfirmDialogFragment
import com.willis.base.dialog.EditDialogBuilder
import com.willis.base.dialog.EditDialogFragment
import com.willis.base.services.api.IDialogService
import kotlinx.coroutines.suspendCancellableCoroutine

/**
 * description: IDialogService 实现类
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/11
 */
internal object DialogService : IDialogService {
    override suspend fun showConfirmDialog(fragment: Fragment, builder: ConfirmDialogBuilder): Boolean? {
        return showConfirmDialog(fragment.childFragmentManager, builder)
    }

    override suspend fun showConfirmDialog(fm: FragmentManager, builder: ConfirmDialogBuilder): Boolean? {
        return suspendCancellableCoroutine { continuation ->
            ConfirmDialogFragment().apply {
                mBuilder = builder
                mContinuation = continuation
            }.show(fm, null)
        }
    }

    override suspend fun showEditDialog(fragment: Fragment, builder: EditDialogBuilder): BaseResult<String> {
        return showEditDialog(fragment.childFragmentManager, builder)
    }

    override suspend fun showEditDialog(fm: FragmentManager, builder: EditDialogBuilder): BaseResult<String> {
        return suspendCancellableCoroutine { continuation ->
            EditDialogFragment().apply {
                mBuilder = builder
                mContinuation = continuation
            }.show(fm, null)
        }
    }
}