package com.gmail.kamemaru2011.fragment.card_list

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gmail.kamemaru2011.R
import com.gmail.kamemaru2011.data.flash_card.Card
import com.gmail.kamemaru2011.data.flash_card.FlashCard
import com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor.FlashCardEditorFragment

class CardListPresenter(private val view: CardListContract.View) : CardListContract.Presenter{
    private lateinit var cardList : ArrayList<Card>

    override fun start() {

    }

    override fun onClickCard(position: Int) {
        view.onClickedCardCallback(cardList[position], position)
    }

    override fun getCardListFromBundle(bundle: Bundle?): CardListContract.Presenter {
        val data = bundle?.getSerializable(BUNDLE_KEY_FLASH_CARD) as FlashCard
        cardList = data.cards ?: ArrayList()

        return this
    }

    override fun getCardListSize(): Int  = cardList.size

    override fun onBindFlashCardDataAtPosition(viewViewHolder: CardListViewHolder, position: Int) {
        viewViewHolder.initLayout(cardList[position])
    }


    class CardListAdapter(private val presenter: CardListContract.Presenter, private val fragment: CardListFragment) : RecyclerView.Adapter<CardListViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardListViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)

            return CardListViewHolder(view, presenter, fragment)
        }

        override fun getItemCount(): Int = presenter.getCardListSize()

        override fun onBindViewHolder(viewViewHolder: CardListViewHolder, position: Int) {
            presenter.onBindFlashCardDataAtPosition(viewViewHolder, position)
        }

    }

    companion object {
        val BUNDLE_KEY_FLASH_CARD = "BUNDLE_KEY_FLASH_CARD"
    }
}