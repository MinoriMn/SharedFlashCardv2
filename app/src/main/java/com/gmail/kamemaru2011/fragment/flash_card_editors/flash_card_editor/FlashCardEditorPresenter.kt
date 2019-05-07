package com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gmail.kamemaru2011.R
import com.gmail.kamemaru2011.activity.flash_card_editors.FlashCardEditorsPresenter
import com.gmail.kamemaru2011.data.flash_card.Card
import com.gmail.kamemaru2011.data.flash_card.FlashCard
import com.gmail.kamemaru2011.utils.LogUtils

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

}