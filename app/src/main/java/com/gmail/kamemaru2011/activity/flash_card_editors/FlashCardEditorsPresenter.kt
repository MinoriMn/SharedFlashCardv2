package com.gmail.kamemaru2011.activity.flash_card_editors

import android.content.Intent
import android.os.Bundle
import com.gmail.kamemaru2011.data.flash_card.FlashCard

class FlashCardEditorsPresenter(private val view: FlashCardEditorsContract.View): FlashCardEditorsContract.Presenter{
    private lateinit var flashCard: FlashCard

    override fun start() {
        val bundle = Bundle()
        bundle.putSerializable(INTENT_EXTRA_FLASH_CARD, flashCard)
        view.setFlashCardEditorFragment(bundle)
    }

    override fun getFlashCardFromIntent(intent: Intent): FlashCardEditorsContract.Presenter {
        flashCard = intent.getSerializableExtra(INTENT_EXTRA_FLASH_CARD) as FlashCard
        return this
    }

    override fun openCardEditor() {
        //TODO fragmentの切り替え

    }

    companion object {
        val INTENT_EXTRA_FLASH_CARD = "INTENT_EXTRA_FLASH_CARD"
    }
}