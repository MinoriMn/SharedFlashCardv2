package com.gmail.kamemaru2011.fragment.top

class TopPagePresenter(val view: TopPageContract.View) : TopPageContract.Presenter{
    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun giveText(s: String?) {
        s?.let { view.setmTextMessage(it) }
    }
}