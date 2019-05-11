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
import com.gmail.kamemaru2011.fragment.flash_card_list.FlashCardListContract
import com.gmail.kamemaru2011.fragment.flash_card_list.FlashCardListPresenter

class CardListFragment  : Fragment(), CardListContract.View {
    override val presenter: CardListContract.Presenter = CardListPresenter(this).also { it.start() }

    private lateinit var recyclerView : RecyclerView
    private lateinit var addCardFAB : FloatingActionButton
    private lateinit var layoutManager : RecyclerView.LayoutManager

    private lateinit var activityMode : ActivityMode
    private val adapter: CardListPresenter.CardListAdapter = CardListPresenter.CardListAdapter(presenter, this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_card_list, container, false)

        recyclerView = view.findViewById(R.id.card_list)
        addCardFAB = view.findViewById<FloatingActionButton>(R.id.add_card)

        layoutManager = LinearLayoutManager(view.context)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager

        val bundel = arguments

        //TODO null時アプリ終了処理
        if (bundel != null) {
            activityMode = bundel.get(BUNDLE_KEY_ACTIVITY_MODE) as ActivityMode
        }

        recyclerView.adapter = adapter

        initLayout()

        return view
    }

    fun initLayout(){
        when(activityMode){
            ActivityMode.Public -> {
                addCardFAB.hide()
            }

            ActivityMode.Edit -> {
                addCardFAB.show()
                addCardFAB.setOnClickListener {
                    presenter.onClickNewCardFAB(activity)
                }
            }
        }
    }

    override fun getChildAdapterPosition(view: View): Int {
        return recyclerView.getChildAdapterPosition(view)
    }

    override fun onResume() {
        super.onResume()
    }

    enum class ActivityMode{
        Public,
        Edit
    }

    companion object {
        const val BUNDLE_KEY_ACTIVITY_MODE = "BUNDLE_KEY_ACTIVITY_MODE"
    }
}