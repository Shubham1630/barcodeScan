package com.androidmarket.scanqr.scanner_feature.tabs.create

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.androidmarket.scanqr.R
import com.androidmarket.scanqr.scanner_extension.clipboardManager
import com.androidmarket.scanqr.scanner_extension.orZero
import com.androidmarket.scanqr.scanner_feature.tabs.create.barcode.CreateBarcodeAllActivity
import com.androidmarket.scanqr.scanner_feature.tabs.create.qr.CreateQrCodeAllActivity
import com.androidmarket.scanqr.scanner_model.schema.BarcodeSchema
import com.google.zxing.BarcodeFormat
import kotlinx.android.synthetic.main.fragment_create_barcode.*
import kotlinx.android.synthetic.main.grid_layout.view.*

class CreateBarcodeAdapter(var context: Context?) : RecyclerView.Adapter<CreateBarcodeAdapter.ViewHolder>() {

    var dataList = emptyList<DataModel>()

    internal fun setDataList(dataList: List<DataModel>) {
        this.dataList = dataList
    }

    // Provide a direct reference to each of the views with data items

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var image: ImageView
        var title: TextView


        init {
            image = itemView.findViewById(R.id.image)
//            itemView.setOnClickListener {
//                when (adapterPosition) {
//                    0 -> CreateBarcodeActivity.start(itemView.context, BarcodeFormat.QR_CODE, BarcodeSchema.OTHER)
//                    1 -> CreateBarcodeActivity.start(itemView.context, BarcodeFormat.QR_CODE, BarcodeSchema.URL)
//                }
//
//            }
            title = itemView.findViewById(R.id.title)
            itemView.setOnClickListener(this);
        }

        override fun onClick(v: View) {
            handleButtonsClicked(v);
        }

        private fun handleButtonsClicked(v: View) {
            when (adapterPosition) {
                0 -> CreateBarcodeActivity.start(v.context, BarcodeFormat.QR_CODE, BarcodeSchema.OTHER, getClipboardContent(v))
                1 -> CreateBarcodeActivity.start(
                    itemView.context,
                    BarcodeFormat.QR_CODE,
                    BarcodeSchema.URL
                )
                2 -> CreateBarcodeActivity.start(
                    itemView.context,
                    BarcodeFormat.QR_CODE,
                    BarcodeSchema.OTHER
                )
                3 -> CreateBarcodeActivity.start(
                    v.context,
                    BarcodeFormat.QR_CODE,
                    BarcodeSchema.WIFI
                )
                4 -> CreateBarcodeActivity.start(
                    v.context,
                    BarcodeFormat.QR_CODE,
                    BarcodeSchema.GEO
                )
                5 -> CreateBarcodeActivity.start(
                    v.context,
                    BarcodeFormat.QR_CODE,
                    BarcodeSchema.VCARD
                )
            }


        }

        private fun getClipboardContent(v: View): String {
            val clip = v.context.clipboardManager?.primaryClip ?: return ""
            return when (clip.itemCount.orZero()) {
                0 -> ""
                else -> clip.getItemAt(0).text.toString()
            }
        }


    }

    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateBarcodeAdapter.ViewHolder {

        // Inflate the custom layout
        var view = LayoutInflater.from(parent.context).inflate(R.layout.grid_layout, parent, false)

        return ViewHolder(view)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: CreateBarcodeAdapter.ViewHolder, position: Int) {

        // Get the data model based on position
        var data = dataList[position]

        // Set item views based on your views and data model
        holder.title.text = data.title
        holder.image.setImageResource(data.image)


    }

    //  total count of items in the list
    override fun getItemCount() = dataList.size


//private fun getClipboardContent(): String {
//    val clip = requireActivity().clipboardManager?.primaryClip ?: return ""
//    return when (clip.itemCount.orZero()) {
//        0 -> ""
//        else -> clip.getItemAt(0).text.toString()
//    }
//}

}

