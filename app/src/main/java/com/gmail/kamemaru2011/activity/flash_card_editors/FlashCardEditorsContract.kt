package com.gmail.kamemaru2011.activity.flash_card_editors

import android.content.Intent
import android.os.Bundle
import com.gmail.kamemaru2011.mvp_base.BasePresenter
import com.gmail.kamemaru2011.mvp_base.BaseView

interface FlashCardEditorsContract {
    interface Presenter: BasePresenter{
        fun getFlashCardFromIntent(intent: Intent): Presenter

        fun openCardEditor()
    }

    interface View: BaseView<Presenter>{
        fun setFlashCardEditorFragment(bundle: Bundle)
        fun setCardEditorFragment(bundle: Bundle)
    }
}
