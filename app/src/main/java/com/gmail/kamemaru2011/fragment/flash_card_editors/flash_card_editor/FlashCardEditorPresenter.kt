package com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor

import android.app.Activity
import android.os.Bundle
import com.gmail.kamemaru2011.activity.flash_card_editors.FlashCardEditorsPresenter
import com.gmail.kamemaru2011.data.flash_card.Card
import com.gmail.kamemaru2011.data.flash_card.FlashCard
import com.gmail.kamemaru2011.fragment.card_list.CardListViewHolder
import com.gmail.kamemaru2011.utils.LogUtils

class FlashCardEditorPresenter(val view: FlashCardEditorContract.View): FlashCardEditorContract.Presenter{
    private var flashCard: FlashCard? = null

    override fun start() {
        if(flashCard == null){
            android.os.Process.killProcess(android.os.Process.myPid())
            System.exit(-1)
        }else{
            //単語張表紙データ
            val flashCardData = flashCard!!.flashCardData
            view.setFlashCardContent(title = flashCardData.title)
        }
    }

    override fun getFlashCardFromBundle(bundle: Bundle?): FlashCardEditorContract.Presenter {
        flashCard = bundle?.getSerializable(FlashCardEditorsPresenter.INTENT_EXTRA_FLASH_CARD) as FlashCard
        return this
    }


}