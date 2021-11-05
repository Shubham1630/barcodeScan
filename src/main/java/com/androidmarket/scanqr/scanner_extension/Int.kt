package com.androidmarket.scanqr.scanner_extension

fun Int?.orZero(): Int {
    return this ?: 0
}