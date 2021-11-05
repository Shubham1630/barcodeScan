package com.androidmarket.scanqr.scanner_extension

fun Double?.orZero(): Double {
    return this ?: 0.0
}