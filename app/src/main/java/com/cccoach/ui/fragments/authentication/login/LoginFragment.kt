package com.cccoach.ui.fragments.authentication.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cccoach.R
import com.cccoach.databinding.FragmentLoginBinding
import com.cccoach.ui.activities.MainActivity
import com.cccoach.ui.base.BaseFragment
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.extensions.setSpanString
import com.cccoach.ui.fragments.authentication.ForgotPassword.ForgotPasswordFragment
import com.cccoach.ui.fragments.authentication.tuts.TutorialGuideSignupsFragment
import com.cccoach.utils.HandleClickListener
import com.cccoach.viewmodel.LoginViewModel


class LoginFragment : BaseFragment(),HandleClickListener {

    var binding:FragmentLoginBinding?=null
    private var loginViewModel:LoginViewModel? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (binding == null)
            binding = FragmentLoginBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {

        binding!!.handleClick=this
        loginFragment=this
        binding!!.signUpHereTV.setSpanString(
            resources.getString(R.string.don_t_have_an_account_sign_up),
            25, 32,
            R.color.red_btn, showBold = true){
            baseActivity!!.replaceFragment(TutorialGuideSignupsFragment(), R.id.frame_container)
        }

    }

    companion object {
        var loginFragment:LoginFragment?=null
    }



    private fun signuptutsFragment() {
        baseActivity!!.replaceFragment(TutorialGuideSignupsFragment(), R.id.frame_container)
    }
    private fun forgotPasswordFragment() {
        baseActivity!!.replaceFragment(ForgotPasswordFragment(), R.id.frame_container)
    }

    override fun onViewClick(view: View) {

        when (view.id) {
            R.id.continueAccountTV -> {
                baseActivity!!.gotMainActivity()
            }
            R.id.signupTV -> {
                signuptutsFragment()
            }
            R.id.forgotPasswordTV -> {
                forgotPasswordFragment()
            }
        }

    }
}