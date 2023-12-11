package com.willis.base.dialog

/**
 * description: ConfirmDialog 配置
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/11
 */
class ConfirmDialogBuilder(
    /**
     * 标题
     */
    val title: CharSequence,

    /**
     * 内容
     */
    val content: CharSequence,

    /**
     * 是否展示取消按钮，默认展示
     */
    val showCancelButton: Boolean = true,

    /**
     * 是否可通过返回键取消，默认可取消
     */
    val isCanceledOnBackPress: Boolean = true,

    /**
     * 是否可点击外部取消，默认可取消
     */
    val isCanceledOnTouchOutside: Boolean = true
)