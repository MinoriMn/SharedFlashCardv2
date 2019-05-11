package com.gmail.kamemaru2011.fragment.card_list

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gmail.kamemaru2011.R
import com.gmail.kamemaru2011.data.flash_card.Card
import com.gmail.kamemaru2011.data.flash_card.FlashCard
import com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor.FlashCardEditorContract
import com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor.FlashCardEditorFragment
import com.gmail.kamemaru2011.utils.LogUtils

class CardListPresenter(private val view: CardListContract.View) : CardListContract.Presenter{
    private lateinit var cardList : ArrayList<Card>


    override fun start() {
        cardList = ArrayList(flashCard!!.cards)

    }


    override fun getCardListSize(): Int  = cardList.size

    override fun onBindFlashCardDataAtPosition(viewViewHolder: CardListViewHolder, position: Int) {
        viewViewHolder.initLayout(cardList[position])
    }

    /**
     * 既存カード編集開始
     */
    override fun onClickCard(activity: Activity?, position: Int) {
        //TODO カード編集画面立ち上げ
        LogUtils.d("CardEditor", "card clicked $position ${cardList.get(position).question.text}")
    }

    /**
     * 新規カード編集開始
     */
    override fun onClickNewCardFAB(activity: Activity?) {
        //TODO カード編集画面立ち上げ
        LogUtils.d("CardEditor", "card clicked new card")

    }

    override fun startCardEditorActivity(activity: Activity?, flashCard: FlashCard) {
        //TODO カード編集画面立ち上げ
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
}