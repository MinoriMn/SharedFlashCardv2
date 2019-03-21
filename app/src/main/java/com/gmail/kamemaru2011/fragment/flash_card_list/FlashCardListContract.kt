package com.gmail.kamemaru2011.fragment.flash_card_list

import com.gmail.kamemaru2011.mvp_base.BasePresenter
import com.gmail.kamemaru2011.mvp_base.BaseView

interface FlashCardListContract{
    interface Presenter: BasePresenter {

    }

    interface View: BaseView<Presenter> {

    }
}