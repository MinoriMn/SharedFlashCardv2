package com.gmail.kamemaru2011.data.flash_card

class FlashCard private constructor(author: Author, flashCardId : Int, title: String, activeType: ActiveType){
    var cards : ArrayList<Card>? = null

    var flashCardData = FlashCardData(author = author, title = title, flashCardID = flashCardId, activeType = activeType)
        private set


    init {
    }

    fun isCardListLoaded(): Boolean = cards != null

    fun loadCardListData(){
        //TODO カードリスト読み込み
    }

    fun newCardListData(){
        cards = ArrayList<Card>()
    }

    inner class FlashCardData(
            var favor: Int = -1, var watched: Int = -1, var genre: FCGenre = FCGenre(), val author: Author = Author(), var title: String = "", //O 表紙データ
            var cardNum: Int = -1, val tags: List<FCTag> = ArrayList<FCTag>(), var lastEditDate: String = "", var explanatoryText: String = "", //I 詳細データ
            var dlNum: Int = -1, var creationDate: String = "", var flashCardID: Int = -0x1, val activeType: ActiveType = ActiveType.ONLINE //U 内部データ
    )

    companion object {
        //新規単語帳生成(this user only)
        fun createNewFlashCard() : FlashCard{
            //TODO ユーザー情報呼び出し
            val author = Author(name = "USER_NAME")
            return FlashCard(author, 0x0,  "new title", ActiveType.MINE_PRIVATE)
        }

        //マイ単語帳ロード
        fun loadMyFlashCard(author: Author, flashCardId : Int, title: String, activeType: ActiveType) : FlashCard{
            return FlashCard(author, flashCardId, title, activeType)
        }

        //単語帳ロード
        fun loadFlashCard(author: Author, flashCardId : Int, title: String) : FlashCard{
            return FlashCard(author, flashCardId, title, ActiveType.ONLINE)
        }
    }

    override fun toString(): String {
        //TODO FlashCard.toString()の上書き
        return flashCardData.title
    }

    enum class ActiveType{
        ONLINE,
        MINE_PRIVATE,
        MINE_PUBLIC,
        MINE_REJECTED
    }
}