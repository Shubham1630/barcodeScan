package com.androidmarket.scanqr.scanner_model

import androidx.room.TypeConverters
import com.androidmarket.scanqr.usecase.BarcodeDatabaseTypeConverter
import com.google.zxing.BarcodeFormat

@TypeConverters(BarcodeDatabaseTypeConverter::class)
data class ExportBarcode(
    val date: Long,
    val format: BarcodeFormat,
    val text: String
)