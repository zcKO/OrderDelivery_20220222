package com.jc.orderdelivery_20220222

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jc.orderdelivery_20220222.adapters.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_pizza_order.*

class MainActivity : AppCompatActivity() {

    lateinit var viewPagerAdapter: MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {

        viewPagerAdapter = MainViewPagerAdapter(supportFragmentManager)
        mainViewPager.adapter = viewPagerAdapter
        mainTabLayout.setupWithViewPager(mainViewPager)

    }

}