package com.jc.orderdelivery_20220222.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.jc.orderdelivery_20220222.R
import com.jc.orderdelivery_20220222.StoreData
import com.jc.orderdelivery_20220222.global.GlobalCode.Companion.PIZZA_DATA
import kotlinx.android.synthetic.main.activity_pizza_order_detail.*

class PizzaOrderDetailActivity : AppCompatActivity() {

    lateinit var data: StoreData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_order_detail)

        getDatas()
        setValues()
        setUpEvents()

    }

    private fun getDatas() {
        data = intent.getSerializableExtra(PIZZA_DATA) as StoreData
    }

    private fun setValues() {

        Glide.with(this)
            .load(data.storeLogoImg)
            .into(storeDetailLogoImg)

        storeDetailName.text = data.storeName
        storeDetailRatingBar.rating = data.storeRating
        storeDetailRatingScore.text = "(${storeDetailRatingBar.rating})"
        storeDetailNumber.text = data.storeNumber

    }

    private fun setUpEvents() {

        orderCallButton.setOnClickListener {



        }

    }

}