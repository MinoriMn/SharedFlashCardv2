package com.gmail.kamemaru2011.fragment.flash_card_list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.gmail.kamemaru2011.R
import kotlinx.android.synthetic.main.nav_header_top.view.*

class FlashCardListAdapter() : RecyclerView.Adapter<FlashCardListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(v : View) : RecyclerView.ViewHolder(v) {
        val titleTextView = v.findViewById<TextView>(R.id.textView)
    }

}