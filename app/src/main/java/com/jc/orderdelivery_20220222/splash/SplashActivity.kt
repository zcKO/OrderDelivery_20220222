package com.jc.orderdelivery_20220222.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.jc.orderdelivery_20220222.MainActivity
import com.jc.orderdelivery_20220222.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        goToMain()
    }

    private fun goToMain() {

        val handler = Handler(Looper.getMainLooper())

        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, 3000)

    }
}