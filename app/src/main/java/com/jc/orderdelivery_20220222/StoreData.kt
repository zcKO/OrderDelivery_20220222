package com.jc.orderdelivery_20220222

import java.io.Serializable

class StoreData(
    val storeName: String,
    val storeRating: Float,
    val storeNumber: String,
    val storeLogoImg: String
) : Serializable