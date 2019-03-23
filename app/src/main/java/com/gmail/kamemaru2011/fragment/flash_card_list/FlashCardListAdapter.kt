package com.gmail.kamemaru2011.fragment.flash_card_list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.gmail.kamemaru2011.R

class FlashCardListAdapter(private val presenter: FlashCardListContract.Presenter, private val fragment: FlashCardListFragment) : RecyclerView.Adapter<FlashCardListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.flash_card, parent, false)

        val viewHolder = ViewHolder(view, presenter, fragment)

        return viewHolder
    }

    override fun getItemCount(): Int = presenter.getFCardListSize()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    class ViewHolder(v : View, private val presenter: FlashCardListContract.Presenter, private val fragment: FlashCardListFragment) : RecyclerView.ViewHolder(v), View.OnClickListener, View.OnLongClickListener {
        val titleTextView = v.findViewById<TextView>(R.id.textView)

        init {
            v.setOnClickListener(this)
            v.setOnLongClickListener(this)
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

}