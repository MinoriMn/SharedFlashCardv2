package com.gmail.kamemaru2011.data.flash_card

import java.io.Serializable

class Card(question_text: String, answer_text: String, question_image: ByteArray, answer_image: ByteArray) : Serializable {
    val question: SideData
    val answer: SideData
    var isQuestion = true
        private set


    init {
        question = SideData(question_text, question_image)
        answer = SideData(answer_text, answer_image)
    }

    fun changeStateIsQuestion(): Boolean {
        isQuestion = !isQuestion
        return isQuestion
    }

    //一面のデータ
    inner class SideData(var text: String, var image: ByteArray?) : Serializable{
        constructor(text: String) : this(text, null)
    }

}

