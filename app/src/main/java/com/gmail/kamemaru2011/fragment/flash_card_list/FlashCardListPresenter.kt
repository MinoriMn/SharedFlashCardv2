package com.gmail.kamemaru2011.fragment.flash_card_list

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
            flashCardList.add(FlashCard.loadFlashCard(author, 0x0, true, "DATA_$i"))
        }
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
}