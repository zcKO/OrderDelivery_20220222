package com.jc.orderdelivery_20220222.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jc.orderdelivery_20220222.R
import com.jc.orderdelivery_20220222.StoreData
import com.jc.orderdelivery_20220222.adapters.StoreAdapter
import com.jc.orderdelivery_20220222.detail.PizzaOrderDetailActivity
import com.jc.orderdelivery_20220222.global.GlobalCode
import com.jc.orderdelivery_20220222.global.GlobalCode.Companion.PIZZA_DATA
import kotlinx.android.synthetic.main.fragment_pizza_order.*

class PizzaOrderFragment: Fragment() {

    private lateinit var pizzaAdapter: StoreAdapter
    private lateinit var storeList: ArrayList<StoreData>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pizza_order, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViews()
        setEvents()
    }

    private fun initViews() {

        storeList = ArrayList()
        pizzaAdapter = StoreAdapter(requireContext(), R.layout.store_order_item, initStoreData())
        pizzaStoreListView.adapter = pizzaAdapter

    }

    private fun initStoreData(): ArrayList<StoreData> {

        storeList.add(StoreData("피자헛", 3.5f, "1588-5588", GlobalCode.PIZZHUT_LOGO_URL))
        storeList.add(StoreData("파파존스", 4.5f, "1577-8080", GlobalCode.PAPAJOHNS_LOGO_URL))
        storeList.add(StoreData("도미노피자", 2.5f, "1577-3082", GlobalCode.DOMINOS_LOGO_URL))
        storeList.add(StoreData("미스터피자", 5.0f, "1577-007", GlobalCode.MRPIZZA_LOGO_URL))

        return storeList

    }

    private fun setEvents() {

        pizzaStoreListView.setOnItemClickListener { parent, view, position, id ->

            val clickedData = storeList[position]

            val intent = Intent(requireContext(), PizzaOrderDetailActivity::class.java).apply {
                putExtra(PIZZA_DATA, clickedData)
            }
            startActivity(intent)

        }

    }


}