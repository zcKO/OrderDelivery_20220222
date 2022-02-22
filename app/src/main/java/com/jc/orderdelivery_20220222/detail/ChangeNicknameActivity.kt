package com.jc.orderdelivery_20220222.detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jc.orderdelivery_20220222.R
import com.jc.orderdelivery_20220222.global.GlobalCode
import kotlinx.android.synthetic.main.activity_change_nickname.*

class ChangeNicknameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_nickname)

        setUpEvents()

    }

    private fun setUpEvents() {

        saveNicknameButton.setOnClickListener {

            val editNickname = inputNickNameEditText.text.toString()
            val resultIntent = Intent().apply {
                putExtra(GlobalCode.MY_NICKNAME, editNickname)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }

    }

}