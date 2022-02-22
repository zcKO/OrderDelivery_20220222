package com.jc.orderdelivery_20220222.detail

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.jc.orderdelivery_20220222.R
import com.jc.orderdelivery_20220222.datas.StoreData
import com.jc.orderdelivery_20220222.global.GlobalCode
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

        val permissionListener = object : PermissionListener {
            override fun onPermissionGranted() {
                val telUri = Uri.parse("tel:${storeDetailNumber.text}")
                val callIntent = Intent(Intent.ACTION_CALL, telUri)
                startActivity(callIntent)
            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                Toast.makeText(
                    this@PizzaOrderDetailActivity,
                    "전화 권한이 없습니다. 획득 후 사용하세요.",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

        orderCallButton.setOnClickListener {

            TedPermission.create()
                .setPermissionListener(permissionListener)
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()

        }

        homePageButton.setOnClickListener {

            val homeUri = Uri.parse(data.storeHomeUri)
            val homeIntent = Intent(Intent.ACTION_VIEW, homeUri)
            startActivity(homeIntent)

        }

    }

}