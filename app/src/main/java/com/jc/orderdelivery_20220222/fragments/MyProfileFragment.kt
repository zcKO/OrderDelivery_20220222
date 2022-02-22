package com.jc.orderdelivery_20220222.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jc.orderdelivery_20220222.R
import com.jc.orderdelivery_20220222.detail.ChangeNicknameActivity
import com.jc.orderdelivery_20220222.global.GlobalCode
import kotlinx.android.synthetic.main.fragment_my_profile.*

class MyProfileFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUpEvents()

    }

    private fun setUpEvents() {

        changeNicknameButton.setOnClickListener {

            val nicknameIntent = Intent(requireContext(), ChangeNicknameActivity::class.java)
            startActivityForResult(nicknameIntent, GlobalCode.REQ_MY_NICKNAME_CHANGE)

        }

    }

    private fun setValues(resultData: String?) {
        resultData?.let {
            myNicknameTextView.text = it
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GlobalCode.REQ_MY_NICKNAME_CHANGE) {

            if (resultCode == Activity.RESULT_OK) {

                val resultData = data?.getStringExtra(GlobalCode.MY_NICKNAME)
                setValues(resultData)
            }

        }

    }

}