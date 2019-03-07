package com.gmail.kamemaru2011.activity.top

import android.support.v4.app.Fragment
import android.view.MenuItem
import com.gmail.kamemaru2011.mvp_base.BasePresenter
import com.gmail.kamemaru2011.mvp_base.BaseView

interface TopContract{
    interface Prensenter : BasePresenter{
        fun navigationItemSelected(item : MenuItem) : Boolean
    }

    interface View : BaseView<Prensenter>{

        fun fragmentTransaction(fragment : Fragment)
    }
}