package com.androidmarket.scanqr.scanner_extension

import java.util.*

val Locale?.isRussian: Boolean
    get() = this?.language == "ru"