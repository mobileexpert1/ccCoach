package com.cccoach.ui.fragments.Verification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cccoach.R
import com.cccoach.databinding.FragmentForgotPasswordBinding
import com.cccoach.databinding.FragmentVerificationBinding
import com.cccoach.ui.base.BaseFragment
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.fragments.authentication.NewPassword.NewPasswordFragment
import com.cccoach.utils.HandleClickListener

class VerificationFragment : BaseFragment(),HandleClickListener {

    var binding: FragmentVerificationBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null)
            binding = FragmentVerificationBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {
        binding!!.handleClick=this
    }

    override fun onViewClick(view: View) {
        when (view.id) {
            R.id.verificationcontinueTV -> {
                gotoNewPasswordFragment()
            }
            R.id.backIV->{
                requireActivity().supportFragmentManager.popBackStack()
            }
            R.id.otp_view->{
              
            }

        }
    }

    private fun gotoNewPasswordFragment() {
        baseActivity!!.replaceFragment(NewPasswordFragment(), R.id.frame_container)
    }

}