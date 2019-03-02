package com.gmail.kamemaru2011.fragment.top

import android.widget.TextView
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.gmail.kamemaru2011.R
import com.gmail.kamemaru2011.utils.LogUtils.Companion.TAG_DEBUG


class TopPageFragment() : Fragment(), TopPageContract.View {
    private var mTextMessage: TextView? = null
    override val presenter: TopPageContract.Presenter = TopPagePresenter(this)

    //Viewの生成

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_top_page, container, false)
        mTextMessage = view.findViewById(R.id.message)

        val bundle = arguments

        if (bundle != null) {
            presenter.giveText(bundle.getString(DEBUG_BUNDLE_KEY, "none"))
        }

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setmTextMessage(s: String) {
        mTextMessage!!.text = s
    }

    companion object {
        val DEBUG_BUNDLE_KEY = "debug_value"
    }
}