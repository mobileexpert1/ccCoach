package com.cccoach.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.cccoach.R
import com.cccoach.ui.base.BaseActivity
import com.cccoach.utils.Const

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val handler = Handler()
        handler.postDelayed({
            gotoLoginSignUpActivity()
        }, Const.SPLASH_TIMEOUT.toLong())

    }

}