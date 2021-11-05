package com.androidmarket.scanqr.scanner_feature.tabs.settings.permissions

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.androidmarket.scanqr.R
import com.androidmarket.scanqr.scanner_extension.applySystemWindowInsets
import com.androidmarket.scanqr.scanner_feature.BaseActivity
import kotlinx.android.synthetic.main.activity_all_permissions.*

class AllPermissionsActivity : BaseActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, AllPermissionsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_permissions)
        root_view.applySystemWindowInsets(applyTop = true, applyBottom = true)
        toolbar.setNavigationOnClickListener { finish() }
    }
}