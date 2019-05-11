package com.gmail.kamemaru2011.activity.flash_card_editors

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gmail.kamemaru2011.R
import com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor.FlashCardEditorFragment


class FlashCardEditorsActivity : AppCompatActivity(), FlashCardEditorsContract.View {
    override val presenter = FlashCardEditorsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_card_editors)

        presenter.getFlashCardFromIntent(intent).start()
    }

    override fun setFlashCardEditorFragment(bundle: Bundle){
        val fragment = FlashCardEditorFragment()
        fragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, fragment)
        transaction.commit()
    }

    override fun setCardEditorFragment(bundle: Bundle){
        //TODO setCardEditorFragment
        val fragment = FlashCardEditorFragment()
        fragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
