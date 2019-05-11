package com.gmail.kamemaru2011.fragment.card_list

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.gmail.kamemaru2011.data.flash_card.Card
import com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor.FlashCardEditorFragment
import com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor.FlashCardEditorPresenter
import com.gmail.kamemaru2011.mvp_base.BasePresenter
import com.gmail.kamemaru2011.mvp_base.BaseView

interface CardListContract{
    interface Presenter: BasePresenter {
        fun getCardListSize(): Int

        fun onBindFlashCardDataAtPosition(viewViewHolder: CardListViewHolder, position: Int)

        fun getCardListFromBundle(bundle: Bundle?): Presenter

        fun onClickCard(position: Int)
    }

    interface View: BaseView<Presenter> {
        fun getChildAdapterPosition(view: android.view.View): Int
        fun onClickedCardCallback(card: Card, position: Int)

        fun setEditorFragment(editorFragment: FlashCardEditorFragment)
    }
}