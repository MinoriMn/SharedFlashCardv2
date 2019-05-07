package com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.gmail.kamemaru2011.R
import com.gmail.kamemaru2011.data.flash_card.Card
import kotlinx.android.synthetic.main.card.view.*

class CardListHolder(v : View, private val presenter: FlashCardEditorContract.Presenter, private val fragment: FlashCardEditorFragment) : RecyclerView.ViewHolder(v), View.OnClickListener, View.OnLongClickListener {
    private val qContent: View
    private val aContent: View
    private var isQuestion: Boolean = true

    private val qTextView: TextView
    private val aTextview: TextView

    private val qImageView: ImageView
    private val aImageView: ImageView

    init {
        qContent = v.findViewById(R.id.qContent)
        aContent = v.findViewById(R.id.aContent)

        qTextView = v.findViewById(R.id.qContentTextView)
        aTextview = v.findViewById(R.id.aContentTextView)

        qImageView = v.findViewById(R.id.qContentImageView)
        aImageView = v.findViewById(R.id.aContentImageView)
    }

    fun initLayout(card: Card){
        qTextView.text = card.question.text
        aTextview.text = card.answer.text
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLongClick(v: View?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}