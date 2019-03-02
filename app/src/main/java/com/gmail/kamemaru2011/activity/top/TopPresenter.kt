package com.gmail.kamemaru2011.activity.top

import android.view.MenuItem
import com.gmail.kamemaru2011.utils.LogUtils

class TopPresenter(view: TopContract.View) : TopContract.Prensenter{
    private val view: TopContract.View = view

    override fun bottomNavigationItemSelected(item: MenuItem) : Boolean {
        //TODO Fragment遷移実装
        LogUtils.d("TopPresenter#bottomNavigationItemSelected", "item: ${item.title}")
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