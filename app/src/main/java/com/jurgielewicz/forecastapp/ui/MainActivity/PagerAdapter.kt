package com.jurgielewicz.forecastapp.ui.MainActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    var fragmentItems: ArrayList<Fragment> = ArrayList()
    var fragmentTitles: ArrayList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return fragmentItems[position]
    }

    override fun getCount(): Int {
        return fragmentItems.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitles[position]
    }

    fun addFragments(item: Fragment, title: String){
        fragmentItems.add(item)
        fragmentTitles.add(title)

    }
}