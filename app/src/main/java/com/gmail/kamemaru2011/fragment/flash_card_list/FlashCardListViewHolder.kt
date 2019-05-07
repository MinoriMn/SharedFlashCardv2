package com.gmail.kamemaru2011.fragment.flash_card_list

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.gmail.kamemaru2011.R
import com.gmail.kamemaru2011.data.flash_card.FlashCard

class FlashCardListViewHolder(v : View, private val presenter: FlashCardListContract.Presenter, private val fragment: FlashCardListFragment) : RecyclerView.ViewHolder(v), View.OnClickListener, View.OnLongClickListener {
    private val titleTextView = v.findViewById<TextView>(R.id.titleTextview)
    private val genreTextView = v.findViewById<TextView>(R.id.genreText)
    private val tagTextView = v.findViewById<TextView>(R.id.tagText)

    private val favorIcon = v.findViewById<ImageView>(R.id.favorIcon)
    private val watchIcon = v.findViewById<ImageView>(R.id.watchIcon)
    private val numFavorTextView = v.findViewById<TextView>(R.id.numFavorTextview)
    private val numWatchTextView = v.findViewById<TextView>(R.id.numWatchTextview)

    private val publishedIcon = v.findViewById<ImageView>(R.id.publishedIcon)

    private val userIcon = v.findViewById<ImageView>(R.id.userIcon)
    private val userNameTextView = v.findViewById<TextView>(R.id.userNameTextview)

    init {
        v.setOnClickListener(this)
        v.setOnLongClickListener(this)
    }

    fun initLayout(activeType: FlashCard.ActiveType){
        when(activeType){
            FlashCard.ActiveType.MINE_PUBLIC->{
                publishedIcon.setImageResource(R.drawable.ic_baseline_public_24px)
            }
            FlashCard.ActiveType.MINE_PRIVATE->{
                publishedIcon.setImageResource(R.drawable.ic_baseline_lock_24px)
                genreTextView.visibility = View.GONE
                tagTextView.visibility = View.GONE
                favorIcon.visibility = View.GONE
                numFavorTextView.visibility = View.GONE
                watchIcon.visibility = View.GONE
                numWatchTextView.visibility = View.GONE
            }
            FlashCard.ActiveType.MINE_REJECTED->{
                publishedIcon.setImageResource(R.drawable.ic_baseline_block_24px)
            }
            FlashCard.ActiveType.ONLINE->{
                publishedIcon.visibility = View.GONE
            }
        }
    }

    fun setContent(title: String? = null, username: String? = null){
        //TODO コンテンツセットの実装
        title?.let { titleTextView.text = it }

        username?.let { userNameTextView.text = it }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            presenter.onClickFlashCard(fragment.activity, fragment.getChildAdapterPosition(v))
        }
    }

    override fun onLongClick(v: View?): Boolean {
        //TODO LongClickListenerの分岐
        if (v != null) {
            presenter.onClickFlashCard(fragment.activity, fragment.getChildAdapterPosition(v))
        }
        return true
    }
}