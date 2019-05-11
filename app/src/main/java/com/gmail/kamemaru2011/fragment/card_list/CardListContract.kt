package com.gmail.kamemaru2011.fragment.card_list

import android.app.Activity
import com.gmail.kamemaru2011.data.flash_card.FlashCard
import com.gmail.kamemaru2011.mvp_base.BasePresenter
import com.gmail.kamemaru2011.mvp_base.BaseView

interface CardListContract{
    interface Presenter: BasePresenter {
        fun onClickNewCardFAB(activity: Activity?)
        fun onClickCard(activity: Activity?, position: Int)
        fun startCardEditorActivity(activity: Activity?, flashCard: FlashCard)

        fun getCardListSize(): Int

        fun onBindFlashCardDataAtPosition(viewViewHolder: CardListViewHolder, position: Int)
    }

    interface View: BaseView<Presenter> {
        fun getChildAdapterPosition(view: android.view.View): Int
    }
}