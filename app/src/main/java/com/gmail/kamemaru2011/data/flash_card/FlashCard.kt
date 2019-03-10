package com.gmail.kamemaru2011.data.flash_card

class FlashCard(private val author: Author, private val flashCardId : Int){
    private val cards : List<Card> = ArrayList<Card>()

    private var favor : Int//お気に入り数
    private var watched : Int//閲覧数
    private var genre : String


    init {
        favor = 0
        watched = 0
        genre = ""
    }
}