package com.androidmarket.scanqr.scanner_extension

import com.androidmarket.scanqr.scanner_model.Barcode
import com.google.zxing.Result

fun Result.equalTo(barcode: Barcode?): Boolean {
    return barcodeFormat == barcode?.format && text == barcode?.text
}