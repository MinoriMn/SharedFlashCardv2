package com.gmail.kamemaru2011.fragment.flash_card_list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.gmail.kamemaru2011.R

class FlashCardListViewHolder(v : View, private val presenter: FlashCardListContract.Presenter, private val fragment: FlashCardListFragment) : RecyclerView.ViewHolder(v), View.OnClickListener, View.OnLongClickListener {
    private val titleTextView = v.findViewById<TextView>(R.id.textView)

    init {
        v.setOnClickListener(this)
        v.setOnLongClickListener(this)
    }

    fun setContent(title: String? = null){
        title?.let { titleTextView.text = it }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            presenter.onClickFlashCard(position = fragment.getChildAdapterPosition(v))
        }
    }

    override fun onLongClick(v: View?): Boolean {
        //TODO LongClickListenerの分岐
        if (v != null) {
            presenter.onClickFlashCard(position = fragment.getChildAdapterPosition(v))
        }
        return true
    }
}