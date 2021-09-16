package cn.xuyonghong.permission.dialog

import androidx.fragment.app.FragmentActivity
import cn.xuyonghong.permission.R


class DefaultExplainDialog : BasePermissionDialog() {

    override fun showDialogWithPermissions(
        activity: FragmentActivity,
        permissions: Array<out String>
    ) {
        showDialog(activity)
    }

    override fun getPositiveViewId(): Int  = R.id.tv_default_explain_dialog_confirm

    override fun getNegativeViewId(): Int = 0

    override fun getLayoutId(): Int = R.layout.fragment_default_explain_dialog

}