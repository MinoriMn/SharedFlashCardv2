package com.gmail.kamemaru2011.fragment.flash_card_list

import android.annotation.SuppressLint
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.gmail.kamemaru2011.R
import com.gmail.kamemaru2011.data.flash_card.Author
import com.gmail.kamemaru2011.data.flash_card.FlashCard

class FlashCardListFragment() : Fragment(), FlashCardListContract.View {
    override val presenter: FlashCardListContract.Presenter = FlashCardListPresenter(this)

    private lateinit var recyclerView : RecyclerView
    private lateinit var addFlashCardFAB : FloatingActionButton
    private lateinit var layoutManager : RecyclerView.LayoutManager

    private lateinit var activityMode : ActivityMode
    private val adapter: FlashCardListAdapter = FlashCardListAdapter(presenter, this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_flash_card_list, container, false)

        recyclerView = view.findViewById(R.id.flash_card_list)
        addFlashCardFAB = view.findViewById(R.id.add_flash_card)

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
                addFlashCardFAB.hide()
            }

            ActivityMode.Mine -> {
                addFlashCardFAB.show()
                addFlashCardFAB.setOnClickListener {
                    presenter.onClickNewCardFAB()
                }
            }
        }
    }

    override fun getChildAdapterPosition(view: View): Int {
        return recyclerView.getChildAdapterPosition(view)
    }

    enum class ActivityMode{
        Public,
        Mine
    }

    companion object {
        val BUNDLE_KEY_ACTIVITY_MODE = "BUNDLE_KEY_ACTIVITY_MODE"
    }
}