package cn.xuyonghong.permission

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import cn.xuyonghong.permission.request.PermissionRequest

/**
 * permission request flow
 * https://developer.android.com/training/permissions/requesting?hl=zh-cn
 */

class Permission(private val activity: FragmentActivity) {

    companion object {
        fun with(activity: FragmentActivity): Permission {
            return Permission(activity)
        }

        fun with(fragment: Fragment): Permission {
            return Permission(fragment.requireActivity())
        }
    }

    /**
     * setup permissions
     */
    fun permissions(vararg permissions: String): PermissionRequest {
        return PermissionRequest(activity, permissions)
    }

}