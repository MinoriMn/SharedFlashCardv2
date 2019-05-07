package com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor

import android.app.Activity
import android.os.Bundle
import com.gmail.kamemaru2011.mvp_base.BasePresenter
import com.gmail.kamemaru2011.mvp_base.BaseView

interface FlashCardEditorContract{
    interface Presenter: BasePresenter{
        fun onClickNewCardFAB(activity: Activity?)

        fun getCardListSize(): Int

        fun onClickCard(activity: Activity?, position: Int)

        fun getFlashCardFromBundle(bundle: Bundle?): Presenter

        fun onBindFlashCardDataAtPosition(viewHolder: CardListHolder, position: Int)
    }

    interface View: BaseView<Presenter>{
        fun setFlashCardContent(title: String? = null, username: String? = null)

        fun getChildAdapterPosition(view: android.view.View): Int
    }
}