package com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gmail.kamemaru2011.R
import com.gmail.kamemaru2011.data.flash_card.Card
import com.gmail.kamemaru2011.data.flash_card.FlashCard

class FlashCardEditorPresenter(val view: FlashCardEditorContract.View): FlashCardEditorContract.Presenter{
    private val cardList = ArrayList<Card>()
    private lateinit var flashCard: FlashCard

    override fun start() {

    }

    override fun setFlashCard(flashCard: FlashCard): FlashCardEditorContract.Presenter {
        this.flashCard = flashCard
        return this
    }

    override fun getCardListSize(): Int = cardList.size

    class FlashCardEditorAdapter(private val presenter: FlashCardEditorContract.Presenter, private val fragment: FlashCardEditorFragment) : RecyclerView.Adapter<FlashCardEditorViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashCardEditorViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.flash_card, parent, false)

            return FlashCardEditorViewHolder(view, presenter, fragment)
        }

        override fun getItemCount(): Int = presenter.getCardListSize()

        override fun onBindViewHolder(p0: FlashCardEditorViewHolder, p1: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

}