package com.jc.orderdelivery_20220222.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.jc.orderdelivery_20220222.fragments.MyProfileFragment
import com.jc.orderdelivery_20220222.fragments.PizzaOrderFragment

class MainViewPagerAdapter(
    fm: FragmentManager,
    private val pager: Int = 2
) : FragmentPagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "피자 주문"
            else -> "내 정보 설정"
        }
    }

    override fun getCount(): Int = pager

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> PizzaOrderFragment()
            else -> MyProfileFragment()
        }
    }

}