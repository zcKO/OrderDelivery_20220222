package com.jc.orderdelivery_20220222.datas

import java.io.Serializable

class StoreData(
    val storeName: String,
    val storeRating: Float,
    val storeNumber: String,
    val storeLogoImg: String,
    val storeHomeUri: String
) : Serializable