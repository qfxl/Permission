package com.qfxl.app

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.xuyonghong.permission.Permission
import com.qfxl.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            btnCameraPermission.setOnClickListener {
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