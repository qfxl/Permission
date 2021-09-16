package com.qfxl.app

import android.content.Context
import android.widget.Toast

/**
 * author : qfxl
 * e-mail : xuyonghong0822@gmail.com
 * time   : 2021/09/16
 * desc   :
 * version: 1.0
 */
fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}