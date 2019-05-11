package com.gmail.kamemaru2011.fragment.card_list

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gmail.kamemaru2011.R
import com.gmail.kamemaru2011.data.flash_card.Card
import com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor.FlashCardEditorFragment
import java.text.FieldPosition

class CardListFragment  : Fragment(), CardListContract.View {
    override val presenter: CardListContract.Presenter = CardListPresenter(this)

    private lateinit var recyclerView : RecyclerView
    private lateinit var layoutManager : RecyclerView.LayoutManager

    private val adapter: CardListPresenter.CardListAdapter = CardListPresenter.CardListAdapter(presenter, this)

    private var editorFragment: FlashCardEditorFragment? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_card_list, container, false)

        recyclerView = view.findViewById(R.id.card_list)

        layoutManager = LinearLayoutManager(view.context)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager

        val bundel = arguments

        presenter.getCardListFromBundle(bundel).start()

        recyclerView.adapter = adapter

        return view
    }

    override fun setEditorFragment(editorFragment: FlashCardEditorFragment) {
        this.editorFragment = editorFragment
    }

    override fun getChildAdapterPosition(view: View): Int {
        return recyclerView.getChildAdapterPosition(view)
    }

    override fun onClickedCardCallback(card: Card, position: Int) {
        if(editorFragment != null){
            editorFragment!!.onClick(card, position)
        }else{
            throw IllegalStateException("not set editor fragment.")
        }
    }

    override fun onResume() {
        super.onResume()
    }

}