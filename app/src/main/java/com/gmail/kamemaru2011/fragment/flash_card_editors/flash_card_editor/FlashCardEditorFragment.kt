package com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gmail.kamemaru2011.R


class FlashCardEditorFragment() : Fragment(), FlashCardEditorContract.View, View.OnClickListener {
    override val presenter = FlashCardEditorPresenter(this).also { it.start() }
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_flash_card_editor, container, false)

        recyclerView = view.findViewById(R.id.recyclerview)

        initLayout(view)

        return view
    }

    private fun initLayout(view: View){
        view.findViewById<View>(R.id.statusData).visibility = View.GONE
        view.findViewById<View>(R.id.userIcon).visibility = View.GONE
        view.findViewById<View>(R.id.userNameTextview).visibility = View.GONE
        view.findViewById<View>(R.id.textData).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.textData -> 0//TODO 単語帳データ編集
        }
    }
}