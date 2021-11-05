package com.androidmarket.scanqr.scanner_extension

import androidx.appcompat.app.AppCompatActivity
import com.androidmarket.scanqr.scanner_feature.common.dialog.ErrorDialogFragment

fun AppCompatActivity.showError(error: Throwable?) {
    val errorDialog =
        ErrorDialogFragment.newInstance(
            this,
            error
        )
    errorDialog.show(supportFragmentManager, "")
}