package com.willis.baselibrary

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.willis.base.services.toastService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.main_btn_1).setOnClickListener {
            lifecycleScope.launch {
                withContext(Dispatchers.Default) {
                    toastService.showNormal("你好")
                }
            }
        }

        findViewById<Button>(R.id.main_btn_2).setOnClickListener {
            toastService.showRight("你好")
        }

        findViewById<Button>(R.id.main_btn_3).setOnClickListener {
            toastService.showError("你好")
        }


    }
}