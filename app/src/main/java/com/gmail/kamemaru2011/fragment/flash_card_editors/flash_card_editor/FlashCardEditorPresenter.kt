package com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor

import android.os.Bundle
import com.gmail.kamemaru2011.activity.flash_card_editors.FlashCardEditorsPresenter
import com.gmail.kamemaru2011.data.flash_card.Card
import com.gmail.kamemaru2011.data.flash_card.FlashCard
import com.gmail.kamemaru2011.fragment.card_list.CardListFragment
import com.gmail.kamemaru2011.fragment.card_list.CardListPresenter
import com.gmail.kamemaru2011.utils.LogUtils

class FlashCardEditorPresenter(val view: FlashCardEditorFragment): FlashCardEditorContract.Presenter{
    private var flashCard: FlashCard? = null

//    private val onClickCardListItemListener = object : OnClickCardListItemListener{
//
//    }

    override fun start() {
        //単語張表紙データ
        val flashCardData = flashCard?.flashCardData
        view.setFlashCardContent(title = flashCardData?.title)

        //cardList読み込み
        val cardListFragment = CardListFragment()
        val args = Bundle()
        args.putSerializable(CardListPresenter.BUNDLE_KEY_FLASH_CARD, flashCard)
        cardListFragment.arguments = args
        cardListFragment.setEditorFragment(view)
        view.setCardListFragment(cardListFragment)
    }

    override fun getFlashCardFromBundle(bundle: Bundle?): FlashCardEditorContract.Presenter {
        flashCard = bundle?.getSerializable(FlashCardEditorsPresenter.INTENT_EXTRA_FLASH_CARD) as FlashCard
        return this
    }

    /**
     * 既存カード編集開始
     */
    override fun onClickCard(card: Card) {
        //TODO カード編集画面立ち上げ
        LogUtils.d("CardEditor", "card clicked ${card.question.text}")
    }

    /**
     * 新規カード編集開始
     */
    override fun onClickNewCardFAB() {
        //TODO カード編集画面立ち上げ
        LogUtils.d("CardEditor", "card clicked new card")

    }

    override fun startCardEditorActivity() {
        //TODO カード編集画面立ち上げ
    }
}