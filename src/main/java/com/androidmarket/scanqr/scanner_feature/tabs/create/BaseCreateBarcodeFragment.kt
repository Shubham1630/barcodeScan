package com.androidmarket.scanqr.scanner_feature.tabs.create

import androidx.fragment.app.Fragment
import com.androidmarket.scanqr.scanner_extension.*
import com.androidmarket.scanqr.scanner_model.Contact
import com.androidmarket.scanqr.scanner_model.schema.Other
import com.androidmarket.scanqr.scanner_model.schema.Schema

abstract class BaseCreateBarcodeFragment : Fragment() {
    protected val parentActivity by unsafeLazy { requireActivity() as CreateBarcodeActivity }

    open val latitude: Double? = null
    open val longitude: Double? = null

    open fun getBarcodeSchema(): Schema = Other("")
    open fun showPhone(phone: String) {}
    open fun showContact(contact: Contact) {}
    open fun showLocation(latitude: Double?, longitude: Double?) {}
}