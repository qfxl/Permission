/*
 * Copyright (C)  XU YONGHONG, Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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