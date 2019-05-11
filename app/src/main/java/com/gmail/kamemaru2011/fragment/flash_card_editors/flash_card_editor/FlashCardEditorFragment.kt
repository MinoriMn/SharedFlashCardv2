package com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.gmail.kamemaru2011.R


class FlashCardEditorFragment() : Fragment(), FlashCardEditorContract.View, View.OnClickListener {
    override val presenter = FlashCardEditorPresenter(this)
    private lateinit var recyclerView: RecyclerView

    private lateinit var titleTextView: TextView
    private lateinit var genreTextView: TextView
    private lateinit var tagTextView: TextView

    private lateinit var favorIcon: ImageView
    private lateinit var watchIcon: ImageView
    private lateinit var numFavorTextView: TextView
    private lateinit var numWatchTextView: TextView

    private lateinit var publishedIcon: ImageView

    private lateinit var addFlashCardFAB : FloatingActionButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_flash_card_editor, container, false)

        titleTextView = view.findViewById<TextView>(R.id.titleTextview)
        genreTextView = view.findViewById<TextView>(R.id.genreText)
        tagTextView = view.findViewById<TextView>(R.id.tagText)

        favorIcon = view.findViewById<ImageView>(R.id.favorIcon)
        watchIcon = view.findViewById<ImageView>(R.id.watchIcon)
        numFavorTextView = view.findViewById<TextView>(R.id.numFavorTextview)
        numWatchTextView = view.findViewById<TextView>(R.id.numWatchTextview)

        publishedIcon = view.findViewById<ImageView>(R.id.publishedIcon)

        addFlashCardFAB = view.findViewById<FloatingActionButton>(R.id.add_card)

        //TODO cardList読み込み


        initLayout(view)

        //presenter起動
        presenter.getFlashCardFromBundle(arguments)
        presenter.start()

        return view
    }

    private fun initLayout(view: View){
        view.findViewById<View>(R.id.userIcon).visibility = View.GONE
        view.findViewById<View>(R.id.userNameTextview).visibility = View.GONE
        view.findViewById<View>(R.id.textData).setOnClickListener(this)

        addFlashCardFAB.setOnClickListener {
            presenter.onClickNewCardFAB(activity)
        }
    }

    override fun setFlashCardContent(title: String?, username: String?){
        //TODO コンテンツセットの実装
        title?.let { titleTextView.text = it }
    }

    override fun getChildAdapterPosition(view: View): Int {
        return recyclerView.getChildAdapterPosition(view)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.textData -> 0//TODO 単語帳データ編集
        }
    }
}