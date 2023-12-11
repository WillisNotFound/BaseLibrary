package com.willis.baselibrary

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.willis.base.dialog.ConfirmDialogBuilder
import com.willis.base.dialog.EditDialogBuilder
import com.willis.base.services.dialogService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.main_btn_1).setOnClickListener {
            lifecycleScope.launchWhenResumed {
                dialogService.showConfirmDialog(supportFragmentManager, ConfirmDialogBuilder("警告", "思考"))
            }
        }

        findViewById<Button>(R.id.main_btn_2).setOnClickListener {
            lifecycleScope.launchWhenResumed {
                dialogService.showEditDialog(supportFragmentManager, EditDialogBuilder("警告", "思考"))
            }
        }


    }
}