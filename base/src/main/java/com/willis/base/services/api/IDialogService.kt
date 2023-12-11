package com.willis.base.services.api

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.willis.base.data.BaseResult
import com.willis.base.dialog.ConfirmDialogBuilder
import com.willis.base.dialog.EditDialogBuilder

/**
 * description: 通用 Dialog 服务
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/11
 */
interface IDialogService {
    /**
     * 展示确认对话框
     * @return true-确认 false-取消 null-无选择关闭
     */
    suspend fun showConfirmDialog(fragment: Fragment, builder: ConfirmDialogBuilder): Boolean?

    /**
     * 展示确认对话框
     * @return true-确认 false-取消 null-无选择关闭
     */
    suspend fun showConfirmDialog(fm: FragmentManager, builder: ConfirmDialogBuilder): Boolean?

    /**
     * 展示修改对话框
     * @return [BaseResult.Success]-确认修改 [BaseResult.Failure]-取消修改
     */
    suspend fun showEditDialog(fragment: Fragment, builder: EditDialogBuilder): BaseResult<String>

    /**
     * 展示修改对话框
     * @return [BaseResult.Success]-确认修改 [BaseResult.Failure]-取消修改
     */
    suspend fun showEditDialog(fm: FragmentManager, builder: EditDialogBuilder): BaseResult<String>
}