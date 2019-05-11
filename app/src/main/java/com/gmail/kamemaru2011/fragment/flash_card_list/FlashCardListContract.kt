package com.gmail.kamemaru2011.fragment.flash_card_list

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import com.gmail.kamemaru2011.data.flash_card.FlashCard
import com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor.FlashCardEditorContract
import com.gmail.kamemaru2011.mvp_base.BasePresenter
import com.gmail.kamemaru2011.mvp_base.BaseView

interface FlashCardListContract{
    interface Presenter: BasePresenter {
        fun onClickNewCardFAB(activity: Activity?)
        fun onClickFlashCard(activity: Activity?, position: Int)
        fun startFCardEditorActivity(activity: Activity?, flashCard: FlashCard)

        fun getFCardListSize(): Int

        fun onBindFlashCardDataAtPosition(viewHolder: FlashCardListViewHolder, position: Int)

        fun onResume()
    }

    interface View: BaseView<Presenter> {
        fun getChildAdapterPosition(view: android.view.View): Int
    }
}