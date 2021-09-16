package cn.xuyonghong.permission.request

import android.view.View


typealias PermissionCallback = (Boolean, ArrayList<String>) -> Unit

typealias DialogPositiveCallback = (View) -> Unit

typealias DialogNegativeCallback = (View) -> Unit