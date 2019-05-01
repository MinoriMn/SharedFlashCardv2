package com.gmail.kamemaru2011.activity.flash_card_editors

import com.gmail.kamemaru2011.mvp_base.BasePresenter
import com.gmail.kamemaru2011.mvp_base.BaseView

internal interface FlashCardEditorsContract {
    interface Presenter: BasePresenter{
        fun openCardEditor()
    }

    interface View: BaseView<Presenter>{

    }
}
