package cn.xuyonghong.permission.request

import androidx.fragment.app.FragmentActivity
import cn.xuyonghong.permission.core.PermissionChecker
import cn.xuyonghong.permission.core.PermissionFragment
import cn.xuyonghong.permission.dialog.BasePermissionDialog
import cn.xuyonghong.permission.dialog.DefaultExplainDialog
import cn.xuyonghong.permission.dialog.DefaultPermanentDeniedDialog
import cn.xuyonghong.permission.dialog.DefaultRationalDialog


class PermissionRequest(private val activity: FragmentActivity, private val permissions:Array<out String>) {
    private val permissionFragment by lazy {
        PermissionFragment.newInstance(PermissionChecker.optimizeDeprecatedPermission(permissions))
    }

    /**
     * explain permission reason
     */
    private var explainDialog: BasePermissionDialog? = null

    /**
     * explain request reason
     * @param dialog
     */
    fun explainBeforeRequest(dialog: BasePermissionDialog = DefaultExplainDialog()): PermissionRequest {
        explainDialog = dialog
        return this
    }

    /**
     * show request rational dialog
     * @param rationalDialog
     */
    fun showRequestRational(rationalDialog: BasePermissionDialog = DefaultRationalDialog()): PermissionRequest {
        permissionFragment.setUpRationalDialog(rationalDialog)
        return this
    }

    /**
     * show permanent dialog
     * @param permanentDialog
     */
    fun showPermanentDeniedDialog(permanentDialog: BasePermissionDialog = DefaultPermanentDeniedDialog()): PermissionRequest {
        permissionFragment.setUpPermanentDialog(permanentDialog)
        return this
    }

    /**
     * request permission, separate permissions, whether is normal or special
     * @param permissionCallback
     */
    fun request(permissionCallback: PermissionCallback) {
        if (PermissionChecker.isAllPermissionGranted(activity, permissions)) {
            permissionCallback.invoke(true, arrayListOf())
        } else {
            if (explainDialog == null) {
                requestInternal(permissionCallback)
            } else {
                explainDialog?.registerDismissListener {
                    requestInternal(permissionCallback)
                }
                explainDialog?.showDialogWithPermissions(activity, permissions)
            }
        }
    }

    /**
     * real permission request
     * @param permissionCallback callback permission result
     */
    private fun requestInternal(permissionCallback: PermissionCallback) {
        permissionFragment.request(activity, permissionCallback)
    }

}