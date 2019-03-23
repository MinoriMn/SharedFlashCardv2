package com.gmail.kamemaru2011.data.flash_card

class FlashCard private constructor(author: Author, flashCardId : Int, private val isUsers : Boolean, title: String){
    var cards : List<Card> = ArrayList<Card>()
        private set

    var flashCardData = FlashCardData(author = author, title = title, flashCardID = flashCardId)
        private set


    init {
    }

    inner class FlashCardData(
            var favor: Int = -1, var watched: Int = -1, var genre: FCGenre = FCGenre(), val author: Author = Author(), var title: String = "", //O 表紙データ
            var cardNum: Int = -1, val tags: List<FCTag> = ArrayList<FCTag>(), var lastEditDate: String = "", var explanatoryText: String = "", //I 詳細データ
            var dlNum: Int = -1, var creationDate: String = "", var flashCardID: Int = -0x1 //U 内部データ
    )

    companion object {
        //新規単語帳生成(this user only)
        fun createNewFlashCard() : FlashCard{
            //TODO ユーザー情報呼び出し
            val author = Author(name = "USER_NAME")
            return FlashCard(author, 0x0, isUsers = true, title = "new title")
        }

        //単語帳ロード
        fun loadFlashCard(author: Author, flashCardId : Int, isUsers: Boolean, title: String) : FlashCard{
            return FlashCard(author, flashCardId, isUsers, title)
        }
    }

    override fun toString(): String {
        //TODO FlashCard.toString()の上書き
        return flashCardData.title
    }
}