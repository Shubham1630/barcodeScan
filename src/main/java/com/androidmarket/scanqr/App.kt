package com.androidmarket.scanqr

import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import androidx.multidex.MultiDexApplication
import com.androidmarket.scanqr.dependency.settings
import com.androidmarket.scanqr.scanner_model.Admob
import com.androidmarket.scanqr.usecase.Logger
import com.google.android.gms.ads.MobileAds
import io.reactivex.plugins.RxJavaPlugins


class App : MultiDexApplication() {

    override fun onCreate() {
        handleUnhandledRxJavaErrors()
        enableStrictModeIfNeeded()
        applyTheme()
        MobileAds.initialize(this) { }
        Admob.InterstitialA(this)

        super.onCreate()
    }

    private fun applyTheme() {
        settings.reapplyTheme()
    }

    private fun handleUnhandledRxJavaErrors() {
        RxJavaPlugins.setErrorHandler { error ->
            Logger.log(error)
        }
    }

    private fun enableStrictModeIfNeeded() {
        if (true) {
            return
        }

        StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                        .detectAll()
                        .penaltyLog()
                        .penaltyDialog()
                        .build()
        )

        StrictMode.setVmPolicy(
                VmPolicy.Builder()
                        .detectAll()
                        .penaltyLog()
                        .penaltyDropBox()
                        .build()
        )
    }
}