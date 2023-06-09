package com.cccoach.ui.fragments.authentication.NewPassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cccoach.R
import com.cccoach.databinding.FragmentNewPasswordBinding
import com.cccoach.ui.base.BaseFragment
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.fragments.devicepassword.EnterNewPasswordFragment
import com.cccoach.utils.HandleClickListener


class NewPasswordFragment :BaseFragment(),HandleClickListener{

    var binding:FragmentNewPasswordBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (binding == null)
            binding = FragmentNewPasswordBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {
        binding!!.handleClick=this
    }

    private fun gotoenterdevicePassword() {
        baseActivity!!.replaceFragment(EnterNewPasswordFragment(), R.id.frame_container)
    }

    override fun onViewClick(view: View) {
        when (view.id) {
            R.id.newPaswrdcontinueTV -> {
                gotoenterdevicePassword()
            }
            R.id.backIV->{
                requireActivity().supportFragmentManager.popBackStack()
            }

        }
    }


}