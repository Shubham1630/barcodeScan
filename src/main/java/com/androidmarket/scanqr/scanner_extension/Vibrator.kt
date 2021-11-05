package com.androidmarket.scanqr.scanner_extension

import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator

fun Vibrator.vibrateOnce(pattern: LongArray) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        vibrate(VibrationEffect.createWaveform(pattern, -1))
    } else {
        vibrate(pattern, -1)
    }
}