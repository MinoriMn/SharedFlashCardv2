package com.gmail.kamemaru2011.data.flash_card

class FlashCard(private val author: Author, private val flashCardId : Int){
    private val cards : List<Card> = ArrayList<Card>()

    private val flashCardData = FlashCardData()

    init {

    }

    inner class FlashCardData(
            var favor: Int = -1, var watched: Int = -1, var genre: FCGenre = FCGenre(), val author: Author = Author(), var title: String = "", //O 表紙データ
            var cardNum: Int = -1, val tags: List<FCTag> = ArrayList<FCTag>(), var lastEditDate: String = "", var explanatoryText: String = "", //I 詳細データ
            var dlNum: Int = -1, var creationDate: String = "", var flashCardID: Int = -0x1 //U 内部データ
    )
}