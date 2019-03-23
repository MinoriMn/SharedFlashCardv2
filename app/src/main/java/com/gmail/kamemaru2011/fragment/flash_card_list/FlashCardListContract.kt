package com.gmail.kamemaru2011.fragment.flash_card_list

import android.view.View
import com.gmail.kamemaru2011.data.flash_card.FlashCard
import com.gmail.kamemaru2011.mvp_base.BasePresenter
import com.gmail.kamemaru2011.mvp_base.BaseView

interface FlashCardListContract{
    interface Presenter: BasePresenter {
        fun onClickNewCardFAB()
        fun startFCardEditorActivity(flashCard: FlashCard)

        fun getFCardListSize(): Int

        fun onClickFlashCard(position: Int)
    }

    interface View: BaseView<Presenter> {
        fun getChildAdapterPosition(view: android.view.View): Int
    }
}