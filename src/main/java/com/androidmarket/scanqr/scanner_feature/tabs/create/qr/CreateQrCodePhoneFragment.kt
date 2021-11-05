package com.androidmarket.scanqr.scanner_feature.tabs.create.qr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.androidmarket.scanqr.R
import com.androidmarket.scanqr.scanner_extension.isNotBlank
import com.androidmarket.scanqr.scanner_extension.textString
import com.androidmarket.scanqr.scanner_feature.tabs.create.BaseCreateBarcodeFragment
import com.androidmarket.scanqr.scanner_model.schema.Phone
import com.androidmarket.scanqr.scanner_model.schema.Schema
import kotlinx.android.synthetic.main.fragment_create_qr_code_phone.*

class CreateQrCodePhoneFragment : BaseCreateBarcodeFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_create_qr_code_phone, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initEditText()
        handleTextChanged()
    }

    override fun showPhone(phone: String) {
        edit_text.apply {
            setText(phone)
            setSelection(phone.length)
        }
    }

    override fun getBarcodeSchema(): Schema {
        return Phone(edit_text.textString)
    }

    private fun initEditText() {
        edit_text.requestFocus()
    }

    private fun handleTextChanged() {
        edit_text.addTextChangedListener {
            parentActivity.isCreateBarcodeButtonEnabled = edit_text.isNotBlank()
        }
    }
}