package com.gmail.kamemaru2011.activity.top

import android.os.Bundle
import android.view.MenuItem
import com.gmail.kamemaru2011.fragment.top.TopPageFragment
import com.gmail.kamemaru2011.fragment.top.TopPageFragment.Companion.DEBUG_BUNDLE_KEY
import com.gmail.kamemaru2011.utils.LogUtils

class TopPresenter(val view: TopContract.View) : TopContract.Prensenter{
    override fun start() {
        val fragment = TopPageFragment()
        val bundle = Bundle()
        bundle.putString(DEBUG_BUNDLE_KEY, "first")
        fragment.arguments = bundle
        view.fragmentTransaction(fragment)
    }

    override fun bottomNavigationItemSelected(item: MenuItem) : Boolean {
        LogUtils.d("TopPresenter#bottomNavigationItemSelected", "item: ${item.title}")

        val fragment = TopPageFragment()
        val bundle = Bundle()
        bundle.putString(DEBUG_BUNDLE_KEY, item.title.toString())
        fragment.arguments = bundle
        view.fragmentTransaction(fragment)

        return true

        //        when (item.itemId) {
//            R.id.navigation_home -> {
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_dashboard -> {
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_notifications -> {
//                return@OnNavigationItemSelectedListener true
//            }
//        }
//        return false
    }
}