package com.gmail.kamemaru2011.fragment.flash_card_list

import android.content.Context
import android.view.View
import com.gmail.kamemaru2011.data.flash_card.FlashCard
import com.gmail.kamemaru2011.mvp_base.BasePresenter
import com.gmail.kamemaru2011.mvp_base.BaseView

interface FlashCardListContract{
    interface Presenter: BasePresenter {
        fun onClickNewCardFAB(context: Context?)
        fun onClickFlashCard(context: Context?, position: Int)
        fun startFCardEditorActivity(context: Context?, flashCard: FlashCard)

        fun getFCardListSize(): Int

        fun onBindFlashCardDataAtPosition(viewHolder: FlashCardListViewHolder, position: Int)

        fun onResume()
    }

    interface View: BaseView<Presenter> {
        fun getChildAdapterPosition(view: android.view.View): Int
    }
}