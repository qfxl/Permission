package cn.xuyonghong.permission.dialog

import androidx.fragment.app.FragmentActivity
import cn.xuyonghong.permission.R
import cn.xuyonghong.permission.ext.openSetting

class DefaultPermanentDeniedDialog : BasePermissionDialog() {

    init {
        canCancel = false
        positiveCallback = {
            requireActivity().openSetting()
        }
    }

    override fun showDialogWithPermissions(
        activity: FragmentActivity,
        permissions: Array<out String>
    ) {
        showDialog(activity)
    }

    override fun getPositiveViewId(): Int = R.id.tv_default_permanent_denied_dialog_confirm

    override fun getNegativeViewId(): Int = R.id.tv_default_permanent_denied_dialog_cancel

    override fun getLayoutId(): Int = R.layout.fragment_default_permanent_denied_dialog
}