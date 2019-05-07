package com.gmail.kamemaru2011.data.flash_card

import java.io.Serializable

class FlashCard private constructor(author: Author, flashCardId : Int, title: String, activeType: ActiveType, cards : ArrayList<Card>): Serializable{
    var cards : ArrayList<Card> = ArrayList(cards)
    private set

    var flashCardData = FlashCardData(author = author, title = title, flashCardID = flashCardId, activeType = activeType)
        private set

    fun addCard(card: Card){
        cards.add(card)
    }

    fun removeCard(position: Int){
        cards.removeAt(position)
    }

    fun replaceCard(from: Int, to: Int){
        cards.add(to, cards.removeAt(from))
    }

    inner class FlashCardData (
            var favor: Int = -1, var watched: Int = -1, var genre: FCGenre = FCGenre(), val author: Author = Author(), var title: String = "", //O 表紙データ
            var cardNum: Int = -1, val tags: List<FCTag> = ArrayList<FCTag>(), var lastEditDate: String = "", var explanatoryText: String = "", //I 詳細データ
            var dlNum: Int = -1, var creationDate: String = "", var flashCardID: Int = -0x1, val activeType: ActiveType = ActiveType.ONLINE //U 内部データ
    ): Serializable

    companion object {
        //新規単語帳生成(this user only)
        fun createNewFlashCard() : FlashCard{
            //TODO ユーザー情報呼び出し
            val cards = ArrayList<Card>()
            val author = Author(name = "USER_NAME")
            return FlashCard(author, 0x0,  "new title", ActiveType.MINE_PRIVATE, cards)
        }

        //マイ単語帳ロード
        fun loadMyFlashCard(author: Author, flashCardId : Int, title: String, activeType: ActiveType) : FlashCard{
            //TODO カード読み込み実装
            //DEBUG
            val cards = ArrayList<Card>()
            for (i in 0..20){
                cards.add(Card("Ques_$i", "Ans_$i", null, null))
            }
            return FlashCard(author, flashCardId, title, activeType, cards)
        }

        //単語帳ロード
        fun loadFlashCard(author: Author, flashCardId : Int, title: String) : FlashCard{
            //TODO カード読み込み実装
            //DEBUG
            val cards = ArrayList<Card>()
            for (i in 0..20){
                cards.add(Card("Ques_$i", "Ans_$i", null, null))
            }
            return FlashCard(author, flashCardId, title, ActiveType.ONLINE, cards)
        }
    }

    override fun toString(): String {
        return flashCardData.title
    }

    enum class ActiveType{
        ONLINE,
        MINE_PRIVATE,
        MINE_PUBLIC,
        MINE_REJECTED
    }
}