package com.gmail.kamemaru2011.activity.top

import android.support.v4.app.Fragment
import android.view.MenuItem
import com.gmail.kamemaru2011.mvp_base.BasePresenter
import com.gmail.kamemaru2011.mvp_base.BaseView

interface TopContract{
    interface Presenter : BasePresenter{
        fun navigationItemSelected(item : MenuItem) : Boolean
    }

    interface View : BaseView<Presenter>{

        fun fragmentTransaction(fragment : Fragment)
    }
}