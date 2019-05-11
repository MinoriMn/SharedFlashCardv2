package com.gmail.kamemaru2011.fragment.flash_card_list

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gmail.kamemaru2011.R
import com.gmail.kamemaru2011.activity.flash_card_editors.FlashCardEditorsActivity
import com.gmail.kamemaru2011.activity.flash_card_editors.FlashCardEditorsPresenter.Companion.INTENT_EXTRA_FLASH_CARD
import com.gmail.kamemaru2011.data.flash_card.Author
import com.gmail.kamemaru2011.data.flash_card.FlashCard

class FlashCardListPresenter(private val view: FlashCardListContract.View) : FlashCardListContract.Presenter{
    private val flashCardList = ArrayList<FlashCard>()

    private var isFCEditorLaunchable = true

    override fun start() {
        //TODO カードのロード処理
        //DEBUG
        for (i in 0..19) {
            val author = Author(name = "USER_NAME")
            flashCardList.add(FlashCard.loadMyFlashCard(author, 0x0, "DATA_${i}AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", if (i % 2 == 0) FlashCard.ActiveType.MINE_PRIVATE else FlashCard.ActiveType.MINE_PUBLIC))
        }
    }

    override fun onResume() {
        isFCEditorLaunchable = true
    }

    override fun onBindFlashCardDataAtPosition(viewHolder: FlashCardListViewHolder, position: Int) {
        val flashCard = flashCardList[position]
        val flashCardData = flashCard.flashCardData
        viewHolder.initLayout(flashCardData.activeType)
        viewHolder.setContent(title = flashCardData.title, username = flashCardData.author.name)
    }

    override fun onClickNewCardFAB(activity: Activity?) {
        startFCardEditorActivity(activity, FlashCard.createNewFlashCard())
    }

    override fun onClickFlashCard(activity: Activity?, position: Int) {
        startFCardEditorActivity(activity, flashCardList[position])
    }

    override fun startFCardEditorActivity(activity: Activity?, flashCard: FlashCard) {
        if(isFCEditorLaunchable) {
            if(!flashCard.isCardListLoaded()) {
                flashCard.loadCardListData()
            }
            val intent = Intent(activity, FlashCardEditorsActivity::class.java)
            intent.putExtra(INTENT_EXTRA_FLASH_CARD, flashCard)
            activity?.startActivity(intent)

            isFCEditorLaunchable = false
        }
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