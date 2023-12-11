package com.willis.baselibrary

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.willis.base.services.toastService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.main_btn_1).setOnClickListener {
            toastService.showNormal("你好")
        }

        findViewById<Button>(R.id.main_btn_2).setOnClickListener {
            toastService.showRight("你好")
        }

        findViewById<Button>(R.id.main_btn_3).setOnClickListener {
            toastService.showError("你好")
        }



    }
}