package com.cccoach.ui.fragments.authentication.ForgotPassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cccoach.R
import com.cccoach.databinding.FragmentForgotPasswordBinding
import com.cccoach.databinding.FragmentLoginBinding
import com.cccoach.ui.base.BaseFragment
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.fragments.Verification.VerificationFragment
import com.cccoach.utils.HandleClickListener


class ForgotPasswordFragment :BaseFragment(),HandleClickListener {

    var binding: FragmentForgotPasswordBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null)
            binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {
        binding!!.handleClick=this

    }

    private fun gotoVerificationFragment() {
        baseActivity!!.replaceFragment(VerificationFragment(), R.id.frame_container)
    }

    override fun onViewClick(view: View) {
        when (view.id) {
            R.id.forgotcontinueTV -> {
                gotoVerificationFragment()
            }
            R.id.backIV->{
                requireActivity().supportFragmentManager.popBackStack()
            }

        }

    }

}