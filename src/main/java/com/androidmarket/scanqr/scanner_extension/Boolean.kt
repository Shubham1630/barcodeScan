package com.androidmarket.scanqr.scanner_extension

fun Boolean?.orFalse(): Boolean {
    return this ?: false
}