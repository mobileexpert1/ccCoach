package com.cccoach.ui.activities

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.cccoach.R
import com.cccoach.ui.base.BaseActivity
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.fragments.authentication.tuts.TutorialGuideLSFragment

class LoginSignUpActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_sign_up)
        gotoSelectRole()
    }

    private fun gotoSelectRole() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        replaceFragment(TutorialGuideLSFragment(), R.id.frame_container)

    }
}