package com.gmail.kamemaru2011.fragment.flash_card_list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gmail.kamemaru2011.R
import com.gmail.kamemaru2011.data.flash_card.Author
import com.gmail.kamemaru2011.data.flash_card.FlashCard
import com.gmail.kamemaru2011.utils.LogUtils

class FlashCardListPresenter(val view: FlashCardListContract.View) : FlashCardListContract.Presenter{
    private val flashCardList = ArrayList<FlashCard>()

    override fun start() {
        //TODO カードのロード処理
        //DEBUG
        for (i in 0..19) {
            val author = Author(name = "USER_NAME")
            flashCardList.add(FlashCard.loadMyFlashCard(author, 0x0, "DATA_$i", if (i % 2 == 0) FlashCard.ActiveType.MINE_PRIVATE else FlashCard.ActiveType.MINE_PUBLIC))
        }
    }

    override fun onBindFlashCardDataAtPosition(viewHolder: FlashCardListViewHolder, position: Int) {
        val flashCard = flashCardList[position]
        val flashCardData = flashCard.flashCardData
        viewHolder.initLayout(flashCardData.activeType)
        viewHolder.setContent(title = flashCardData.title, username = flashCardData.author.name)
    }

    override fun onClickNewCardFAB() {
        startFCardEditorActivity(FlashCard.createNewFlashCard())
    }

    override fun onClickFlashCard(position: Int) {
        startFCardEditorActivity(flashCardList[position])
    }

    override fun startFCardEditorActivity(flashCard: FlashCard) {
        //TODO FlashCardEditorの立ち上げ
        LogUtils.d("#StartFCardEditorActivity", flashCard.toString())
    }

    override fun getFCardListSize(): Int = flashCardList.size

    class FlashCardListAdapter(private val presenter: FlashCardListContract.Presenter, private val fragment: FlashCardListFragment) : RecyclerView.Adapter<FlashCardListViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashCardListViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.flash_card, parent, false)

            return FlashCardListViewHolder(view, presenter, fragment)
        }

        override fun getItemCount(): Int = presenter.getFCardListSize()

        override fun onBindViewHolder(holder: FlashCardListViewHolder, position: Int) {
            presenter.onBindFlashCardDataAtPosition(holder, position)
        }
    }
}