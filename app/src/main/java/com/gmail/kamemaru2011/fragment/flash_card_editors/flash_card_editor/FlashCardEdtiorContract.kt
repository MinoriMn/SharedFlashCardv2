package com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor

import com.gmail.kamemaru2011.mvp_base.BasePresenter
import com.gmail.kamemaru2011.mvp_base.BaseView

interface FlashCardEdtiorContract{
    interface Presenter: BasePresenter{

    }

    interface View: BaseView<Presenter>{

    }
}