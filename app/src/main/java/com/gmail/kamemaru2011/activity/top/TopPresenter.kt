package com.gmail.kamemaru2011.activity.top

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.gmail.kamemaru2011.R
import com.gmail.kamemaru2011.fragment.flash_card_list.FlashCardListFragment
import com.gmail.kamemaru2011.fragment.flash_card_list.FlashCardListFragment.Companion.BUNDLE_KEY_ACTIVITY_MODE
import com.gmail.kamemaru2011.fragment.top.TopPageFragment
import com.gmail.kamemaru2011.fragment.top.TopPageFragment.Companion.DEBUG_BUNDLE_KEY
import com.gmail.kamemaru2011.utils.LogUtils

class TopPresenter(val view: TopContract.View) : TopContract.Presenter{
    override fun start() {
        val fragment = TopPageFragment()
        val bundle = Bundle()
        bundle.putString(DEBUG_BUNDLE_KEY, "first")
        fragment.arguments = bundle
        view.fragmentTransaction(fragment)
    }

    override fun navigationItemSelected(item: MenuItem) : Boolean {
        LogUtils.d("TopPresenter#navigationItemSelected", "item: ${item.title}")


        val bundle = Bundle()

        val fragment = when(item.itemId){
            R.id.navigation_my_flash_card_list -> FlashCardListFragment().apply {
                bundle.putSerializable(BUNDLE_KEY_ACTIVITY_MODE, FlashCardListFragment.ActivityMode.Mine)
            }
            else -> TopPageFragment()
        } as Fragment
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