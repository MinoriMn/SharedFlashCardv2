package com.gmail.kamemaru2011.fragment.top

import com.gmail.kamemaru2011.mvp_base.BasePresenter
import com.gmail.kamemaru2011.mvp_base.BaseView

interface TopPageContract{
    interface Presenter: BasePresenter{
        fun giveText(s: String?)
    }

    interface View: BaseView<Presenter>{
        fun setmTextMessage(s: String)
    }
}