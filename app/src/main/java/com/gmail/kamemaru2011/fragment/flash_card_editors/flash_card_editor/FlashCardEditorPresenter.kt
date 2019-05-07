package com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gmail.kamemaru2011.R
import com.gmail.kamemaru2011.activity.flash_card_editors.FlashCardEditorsPresenter
import com.gmail.kamemaru2011.data.flash_card.Card
import com.gmail.kamemaru2011.data.flash_card.FlashCard

class FlashCardEditorPresenter(val view: FlashCardEditorContract.View): FlashCardEditorContract.Presenter{
    private lateinit var cardList : ArrayList<Card>
    private var flashCard: FlashCard? = null

    override fun start() {
        if(flashCard == null){
            android.os.Process.killProcess(android.os.Process.myPid())
            System.exit(-1)
        }else{
            cardList = ArrayList(flashCard!!.cards)
            //単語張表紙データ
            val flashCardData = flashCard!!.flashCardData
            view.setFlashCardContent(title = flashCardData.title)
        }
    }

    override fun getFlashCardFromBundle(bundle: Bundle?): FlashCardEditorContract.Presenter {
        flashCard = bundle?.getSerializable(FlashCardEditorsPresenter.INTENT_EXTRA_FLASH_CARD) as FlashCard
        return this
    }

    override fun onBindFlashCardDataAtPosition(viewHolder: CardListHolder, position: Int) {
        viewHolder.initLayout(cardList[position])
    }

    override fun getCardListSize(): Int = cardList.size

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

}