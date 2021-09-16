package cn.xuyonghong.permission.dialog

import androidx.fragment.app.FragmentActivity
import cn.xuyonghong.permission.R

class DefaultRationalDialog : BasePermissionDialog() {

    init {
        canCancel = false
    }

    override fun showDialogWithPermissions(
        activity: FragmentActivity,
        permissions: Array<out String>
    ) {
        showDialog(activity)
    }

    override fun getPositiveViewId(): Int = R.id.tv_default_rational_dialog_confirm

    override fun getNegativeViewId(): Int = R.id.tv_default_rational_dialog_cancel

    override fun getLayoutId(): Int = R.layout.fragment_default_rational_dialog
}