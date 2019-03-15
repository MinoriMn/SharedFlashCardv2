package com.gmail.kamemaru2011.data.flash_card

class FlashCard private constructor(author: Author, flashCardId : Int, private val isUsers : Boolean){
    private val cards : List<Card> = ArrayList<Card>()

    private val flashCardData = FlashCardData(author = author, flashCardID = flashCardId)

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
            return FlashCard(author, 0x0, isUsers = true)
        }

        //単語帳ロード(this user or users)
        fun loadFlashCard(author: Author, flashCardId : Int, isUsers: Boolean) : FlashCard{
            return FlashCard(author, flashCardId, isUsers)
        }
    }
}