package com.jc.orderdelivery_20220222.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.jc.orderdelivery_20220222.R
import com.jc.orderdelivery_20220222.datas.StoreData
import com.willy.ratingbar.RotationRatingBar

class StoreAdapter(
    private val mContext: Context,
    private val resId: Int,
    private val mStoreList: ArrayList<StoreData>
) : ArrayAdapter<StoreData>(mContext, resId, mStoreList) {

    lateinit var row: View

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if (tempRow == null) {
            tempRow = LayoutInflater.from(mContext).inflate(resId, null)
        }

        val row = tempRow!!
        setValues(row, position)

        return row

    }

    private fun setValues(row: View, position: Int) {

        val data = mStoreList[position]

        val storeLogoImg = row.findViewById<ImageView>(R.id.storeLogoImageView)
        val storeName = row.findViewById<TextView>(R.id.storeNameTextView)
        val storeRating = row.findViewById<RotationRatingBar>(R.id.storeRatingBar)

        Glide.with(mContext)
            .load(data.storeLogoImg)
            .into(storeLogoImg)

        storeName.text = data.storeName
        storeRating.rating = data.storeRating


    }

}