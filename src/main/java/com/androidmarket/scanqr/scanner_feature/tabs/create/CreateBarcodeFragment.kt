package com.androidmarket.scanqr.scanner_feature.tabs.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidmarket.scanqr.R
import com.androidmarket.scanqr.scanner_extension.applySystemWindowInsets
import com.androidmarket.scanqr.scanner_extension.clipboardManager
import com.androidmarket.scanqr.scanner_extension.orZero
import com.androidmarket.scanqr.scanner_feature.tabs.create.barcode.CreateBarcodeAllActivity
import com.androidmarket.scanqr.scanner_feature.tabs.create.qr.CreateQrCodeAllActivity
import com.androidmarket.scanqr.scanner_model.schema.BarcodeSchema
import com.google.zxing.BarcodeFormat
import kotlinx.android.synthetic.main.fragment_create_barcode.*


class CreateBarcodeFragment : Fragment() {

    private lateinit var  createBarcodeAdapter: CreateBarcodeAdapter
    private var dataList = mutableListOf<DataModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_create_barcode_gridview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.create_barcode_recyclerView)

        recyclerView.layoutManager = GridLayoutManager(context,3)
        createBarcodeAdapter = CreateBarcodeAdapter(context)
        recyclerView.adapter = createBarcodeAdapter

            dataList.add(DataModel(resources.getString(R.string.fragment_create_barcode_qr_code_clipboard),R.drawable.ic_copy))
            dataList.add(DataModel(resources.getString(R.string.fragment_create_barcode_qr_code_text),R.drawable.ic_text))
            dataList.add(DataModel(resources.getString(R.string.barcode_schema_url),R.drawable.ic_link))
            dataList.add(DataModel(resources.getString(R.string.barcode_schema_geo),R.drawable.ic_location))
            dataList.add(DataModel(resources.getString(R.string.barcode_schema_v_card),R.drawable.ic_contact))
            dataList.add(DataModel("Clipboard",R.drawable.ic_qr_code))
            dataList.add(DataModel(R.string.fragment_create_barcode_show_all.toString(),R.drawable.ic_barcode))

            createBarcodeAdapter.setDataList(dataList)

//        supportEdgeToEdge()
//        handleButtonsClicked()

    }

    private fun supportEdgeToEdge() {
        app_bar_layout.applySystemWindowInsets(applyTop = true)
    }

    private fun handleButtonsClicked() {
        // QR code
        button_clipboard.setOnClickListener { CreateBarcodeActivity.start(requireActivity(), BarcodeFormat.QR_CODE, BarcodeSchema.OTHER, getClipboardContent())  }
        button_text.setOnClickListener { CreateBarcodeActivity.start(requireActivity(), BarcodeFormat.QR_CODE, BarcodeSchema.OTHER) }
        button_url.setOnClickListener { CreateBarcodeActivity.start(requireActivity(), BarcodeFormat.QR_CODE, BarcodeSchema.URL) }
        button_wifi.setOnClickListener { CreateBarcodeActivity.start(requireActivity(), BarcodeFormat.QR_CODE, BarcodeSchema.WIFI) }
        button_location.setOnClickListener { CreateBarcodeActivity.start(requireActivity(), BarcodeFormat.QR_CODE, BarcodeSchema.GEO) }
        button_contact_vcard.setOnClickListener { CreateBarcodeActivity.start(requireActivity(), BarcodeFormat.QR_CODE, BarcodeSchema.VCARD) }
        button_show_all_qr_code.setOnClickListener { CreateQrCodeAllActivity.start(requireActivity()) }

        // Barcode
        button_create_barcode.setOnClickListener { CreateBarcodeAllActivity.start(requireActivity()) }
    }

    private fun getClipboardContent(): String {
        val clip = requireActivity().clipboardManager?.primaryClip ?: return ""
        return when (clip.itemCount.orZero()) {
            0 -> ""
            else -> clip.getItemAt(0).text.toString()
        }
    }
}