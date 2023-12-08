package com.willis.base

import android.content.ContentProvider
import android.content.ContentValues
import android.net.Uri
import com.willis.base.utils.initAppContext

/**
 * description: 用于初始化 AppUtils
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/8
 */
internal class Installer: ContentProvider() {
    override fun onCreate(): Boolean {
        initAppContext(context!!)
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ) = null

    override fun getType(uri: Uri) = null

    override fun insert(uri: Uri, values: ContentValues?) = null

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?) = 0

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?) = 0
}