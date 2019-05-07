package com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gmail.kamemaru2011.R

class CardListAdapter(private val presenter: FlashCardEditorContract.Presenter, private val fragment: FlashCardEditorFragment) : RecyclerView.Adapter<CardListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)

        return CardListHolder(view, presenter, fragment)
    }

    override fun getItemCount(): Int = presenter.getCardListSize()

    override fun onBindViewHolder(viewHolder: CardListHolder, position: Int) {
        presenter.onBindFlashCardDataAtPosition(viewHolder, position)
    }

}