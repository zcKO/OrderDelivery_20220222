package com.jc.orderdelivery_20220222.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.jc.orderdelivery_20220222.R
import com.jc.orderdelivery_20220222.StoreData

class StoreAdapter(
    private val mContext: Context,
    resId: Int,
    private val mStoreList: ArrayList<StoreData>
): ArrayAdapter<StoreData>(mContext, resId, mStoreList) {

    lateinit var row: View

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if (tempRow == null) {
            tempRow = LayoutInflater.from(mContext).inflate(R.layout.store_order_item, null)
        }

        tempRow?.let {
            row = it
        }

        return row

    }

}