package com.qfxl.app.permission

import androidx.fragment.app.FragmentActivity
import com.qfxl.app.R
import cn.xuyonghong.permission.dialog.BasePermissionDialog

/**
 * author : qfxl
 * e-mail : xuyonghong0822@gmail.com
 * time   : 2021/09/16
 * desc   :
 * version: 1.0
 */

class SampleExplainDialog : BasePermissionDialog() {

    override fun showDialogWithPermissions(
        activity: FragmentActivity,
        permissions: Array<out String>
    ) {
        showDialog(activity)
    }

    override fun getPositiveViewId(): Int = 0

    override fun getNegativeViewId(): Int = 0

    override fun getLayoutId(): Int = R.layout.fragment_sample_explain
}