package com.gmail.kamemaru2011.data.flash_card

import android.graphics.Bitmap
import java.io.Serializable

class Card(question_text: String, answer_text: String, question_image: Bitmap?, answer_image: Bitmap?) : Serializable {
    val question: SideData
    val answer: SideData

    init {
        question = SideData(question_text, question_image)
        answer = SideData(answer_text, answer_image)
    }

    //一面のデータ
    inner class SideData(var text: String, var image: Bitmap?) : Serializable{
        constructor(text: String) : this(text, null)
    }

}

