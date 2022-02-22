package com.jc.orderdelivery_20220222.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainViewPagerAdapter(
    fm: FragmentManager,
    private val pager: Int = 3
): FragmentPagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence? {
        TODO("포지션에 따라 페이저의 제목 달아주기")
    }

    override fun getCount(): Int = pager

    override fun getItem(position: Int): Fragment {
        TODO("포지션에 따라 프레그먼트 보여주기")

    }


}