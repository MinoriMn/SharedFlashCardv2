package com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.gmail.kamemaru2011.data.flash_card.Card
import com.gmail.kamemaru2011.data.flash_card.FlashCard
import com.gmail.kamemaru2011.fragment.card_list.CardListViewHolder
import com.gmail.kamemaru2011.mvp_base.BasePresenter
import com.gmail.kamemaru2011.mvp_base.BaseView

interface FlashCardEditorContract{
    interface Presenter: BasePresenter{
        fun getFlashCardFromBundle(bundle: Bundle?): Presenter

        fun onClickNewCardFAB()
        fun onClickCard(card: Card)
        fun startCardEditorActivity()
    }

    interface View: BaseView<Presenter>{
        fun setFlashCardContent(title: String? = null, username: String? = null)

        fun getChildAdapterPosition(view: android.view.View): Int

        fun setCardListFragment(fragment: Fragment)
    }
}