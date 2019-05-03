package com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

class FlashCardEditorPresenter(val view: FlashCardEditorContract.View): FlashCardEditorContract.Presenter{
    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class FlashCardEditorAdapter(private val presenter: FlashCardEditorContract.Presenter, private val fragment: FlashCardEditorFragment) : RecyclerView.Adapter<FlashCardEditorViewHolder>() {
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FlashCardEditorViewHolder {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getItemCount(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onBindViewHolder(p0: FlashCardEditorViewHolder, p1: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

}