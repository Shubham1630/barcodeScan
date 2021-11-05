package com.androidmarket.scanqr.scanner_extension

fun Long?.orZero(): Long {
    return this ?: 0L
}