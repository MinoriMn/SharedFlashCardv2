package com.gmail.kamemaru2011.fragment.card_list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.gmail.kamemaru2011.R
import com.gmail.kamemaru2011.data.flash_card.Card
import com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor.FlashCardEditorContract
import com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor.FlashCardEditorFragment

class CardListViewHolder(v : View, private val presenter: CardListContract.Presenter, private val fragment: CardListFragment) : RecyclerView.ViewHolder(v), View.OnClickListener, View.OnLongClickListener {
    private val qContent: View = v.findViewById(R.id.qContent)
    private val aContent: View = v.findViewById(R.id.aContent)
    private var isQuestion: Boolean = true

    private val qTextView: TextView = v.findViewById(R.id.qContentTextView)
    private val aTextView: TextView = v.findViewById(R.id.aContentTextView)

    private val qImageView: ImageView = v.findViewById(R.id.qContentImageView)
    private val aImageView: ImageView = v.findViewById(R.id.aContentImageView)

    init {
        v.setOnClickListener(this)
        v.setOnLongClickListener(this)
    }

    fun initLayout(card: Card){
        qTextView.text = card.question.text
        aTextView.text = card.answer.text
        if(card.question.image != null) {
            qImageView.setImageBitmap(card.question.image)
        }else{
            qImageView.visibility = View.GONE
        }

        if(card.answer.image != null) {
            aImageView.setImageBitmap(card.answer.image)
        }else{
            aImageView.visibility = View.GONE
        }

        changeContent()
    }

    fun setIsQuestion(isQuestion: Boolean){
        this.isQuestion = isQuestion
    }

    fun changeStateIsQuestion(): Boolean {
        isQuestion = !isQuestion
        return isQuestion
    }

    fun changeContent(){
        if(isQuestion){
            qContent.visibility = View.VISIBLE
            aContent.visibility = View.GONE
        }else{
            qContent.visibility = View.GONE
            aContent.visibility = View.VISIBLE
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            presenter.onClickCard(fragment.getChildAdapterPosition(v))
        }
    }

    override fun onLongClick(v: View?): Boolean {
        //TODO LongClickListenerの分岐
        if (v != null) {
            presenter.onClickCard(fragment.getChildAdapterPosition(v))
        }
        return true
    }

}