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

    private var recyclerView : RecyclerView? = null
    private var addFlashCardFAB : FloatingActionButton? = null

    private var adapter : FlashCardListAdapter? = null
    private var layoutManager : RecyclerView.LayoutManager? = null

    private val flashCardList = ArrayList<FlashCard>()

    private lateinit var activityMode : ActivityMode

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_flash_card_list, container, false)

        recyclerView = view.findViewById(R.id.flash_card_list)
        addFlashCardFAB = view.findViewById(R.id.add_flash_card)

        layoutManager = LinearLayoutManager(view.context)

        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = layoutManager

        val bundel = arguments

        //TODO null時アプリ終了処理
        if (bundel != null) {
            activityMode = bundel.get("BUNDLE_KEY_ACTIVITY_MODE") as ActivityMode
        }

        //TODO DEBUG
        for (i in 0..19) {
            val author = Author(name = "USER_NAME")
            flashCardList.add(FlashCard.loadFlashCard(author, 0x0, true, "DATA_$i"))
        }

        return view
    }

    fun initLayout(){
        when(activityMode){
            ActivityMode.Public -> {
                addFlashCardFAB?.hide()
            }

            ActivityMode.Mine -> {
                addFlashCardFAB?.show()
            }
        }
    }

    enum class ActivityMode{
        Public,
        Mine
    }

    companion object {
        val BUNDLE_KEY_ACTIVITY_MODE = "BUNDLE_KEY_ACTIVITY_MODE"
    }
}