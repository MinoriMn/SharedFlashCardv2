package com.gmail.kamemaru2011.fragment.card_list

import com.gmail.kamemaru2011.data.flash_card.Card

interface OnClickCardListItemListener{
    fun onClick(card: Card, position: Int)
}