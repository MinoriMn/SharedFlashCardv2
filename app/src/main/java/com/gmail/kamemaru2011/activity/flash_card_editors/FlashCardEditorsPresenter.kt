package com.gmail.kamemaru2011.activity.flash_card_editors

import android.os.Bundle
import com.gmail.kamemaru2011.data.flash_card.FlashCard
import com.gmail.kamemaru2011.fragment.flash_card_list.FlashCardListPresenter

class FlashCardEditorsPresenter(private val view: FlashCardEditorsContract.View): FlashCardEditorsContract.Presenter{
    private lateinit var flashCard: FlashCard

    override fun start() {
        val bundle = Bundle()
        bundle.putSerializable(FlashCardListPresenter.INTENT_EXTRA_FLASH_CARD, flashCard)
        view.setFlashCardEditorFragment(bundle)
    }

    override fun getFlashCardFromBundle(bundle: Bundle): FlashCardEditorsContract.Presenter {
        flashCard = bundle.getSerializable(FlashCardListPresenter.INTENT_EXTRA_FLASH_CARD) as FlashCard
        return this
    }

    override fun openCardEditor() {
        //TODO fragmentの切り替え

    }

}