package com.gmail.kamemaru2011.activity.flash_card_editors

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.gmail.kamemaru2011.R
import com.gmail.kamemaru2011.fragment.flash_card_editors.flash_card_editor.FlashCardEditorFragment

class FlashCardEditorsActivity : AppCompatActivity(), FlashCardEditorsContract.View {
    override val presenter = FlashCardEditorsPresenter(this).also { it.start() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_card_editors)

        setFlashCardEditorFragment()
    }

    private fun setFlashCardEditorFragment(){
        val fragment = FlashCardEditorFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, fragment)
        transaction.commit()
    }

    fun setCardEditorFragment(){
        //TODO setCardEditorFragment
        val fragment = FlashCardEditorFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
