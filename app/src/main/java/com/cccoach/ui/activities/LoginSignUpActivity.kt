package com.cccoach.ui.activities

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.FragmentManager
import com.cccoach.R
import com.cccoach.ui.base.BaseActivity
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.fragments.Learner.home.HomeFragment
import com.cccoach.ui.fragments.Verification.VerificationFragment
import com.cccoach.ui.fragments.authentication.ForgotPassword.ForgotPasswordFragment
import com.cccoach.ui.fragments.authentication.NewPassword.NewPasswordFragment
import com.cccoach.ui.fragments.authentication.login.LoginFragment
import com.cccoach.ui.fragments.authentication.signup.SignupCoachFragment
import com.cccoach.ui.fragments.authentication.tuts.TutorialGuideLSFragment
import com.cccoach.ui.fragments.authentication.tuts.TutorialGuideSignupsFragment
import com.cccoach.ui.fragments.devicepassword.EnterNewPasswordFragment

class LoginSignUpActivity : BaseActivity() {
    private var exit: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_sign_up)
       gotoSelectRole()
    }

    private fun gotoSelectRole() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        replaceFragment(TutorialGuideLSFragment(), R.id.frame_container)

    }


    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.frame_container)
        when {
            fragment is TutorialGuideLSFragment -> {
                backAction()
            }
            fragment is TutorialGuideSignupsFragment->{
                replaceFragment(TutorialGuideLSFragment(), R.id.frame_container)
            }
            fragment is SignupCoachFragment->{
                replaceFragment(TutorialGuideSignupsFragment(), R.id.frame_container)
            }
            fragment is LoginFragment->{
                replaceFragment(TutorialGuideLSFragment(), R.id.frame_container)
            }
            fragment is ForgotPasswordFragment->{
                replaceFragment(LoginFragment(), R.id.frame_container)
            }
            fragment is VerificationFragment->{
                replaceFragment(ForgotPasswordFragment(), R.id.frame_container)
            }
            fragment is NewPasswordFragment->{
                replaceFragment(VerificationFragment(), R.id.frame_container)
            }
            supportFragmentManager.backStackEntryCount > 0 -> {
                supportFragmentManager.popBackStack()
            }
            else -> {
               // gotoLoginFragment()
            }
        }
    }

    fun backAction() {
        if (exit) {
            finishAffinity()
        } else {
            showToastOne(getString(R.string.press_one_more_time))
            exit = true
            Handler(Looper.getMainLooper()).postDelayed({ exit = false }, (2 * 1000).toLong())
        }
    }

}