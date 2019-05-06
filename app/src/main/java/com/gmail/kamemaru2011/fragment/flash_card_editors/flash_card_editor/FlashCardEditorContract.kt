package com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor

import com.gmail.kamemaru2011.data.flash_card.FlashCard
import com.gmail.kamemaru2011.mvp_base.BasePresenter
import com.gmail.kamemaru2011.mvp_base.BaseView

interface FlashCardEditorContract{
    interface Presenter: BasePresenter{
        fun getCardListSize(): Int

        fun setFlashCard(flashCard: FlashCard): Presenter
    }

    interface View: BaseView<Presenter>{

    }
}