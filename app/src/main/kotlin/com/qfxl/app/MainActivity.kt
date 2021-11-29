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

package com.qfxl.app

import android.Manifest
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import cn.xuyonghong.permission.Permission

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_camera_permission).apply {

            setOnClickListener {
                Permission.with(this@MainActivity)
                    .permissions(
                        Manifest.permission.CAMERA
                    )
                    .explainBeforeRequest()
                    .showRequestRational()
                    .showPermanentDeniedDialog()
                    .request { allGranted, deniedPermissions ->
                        if (allGranted) {
                            toast("all permission granted")
                        } else {
                            toast("some permission are denied，${deniedPermissions}")
                        }
                    }
            }
        }
    }

}