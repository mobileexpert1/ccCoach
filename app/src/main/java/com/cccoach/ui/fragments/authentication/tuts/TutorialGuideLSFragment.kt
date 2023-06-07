package com.cccoach.ui.fragments.authentication.tuts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cccoach.R
import com.cccoach.databinding.FragmentTutorialGuideLSBinding
import com.cccoach.ui.base.BaseFragment
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.fragments.authentication.login.LoginFragment
import com.cccoach.utils.HandleClickListener

class TutorialGuideLSFragment : BaseFragment(), HandleClickListener {

    var binding:FragmentTutorialGuideLSBinding?=null

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
            binding = FragmentTutorialGuideLSBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun initUI() {
        binding!!.handleClick = this
    }

    private fun signuptutsFragment() {
        baseActivity!!.replaceFragment(TutorialGuideSignupsFragment(), R.id.frame_container)
    }

    private fun gotoLoginFragment(){
        baseActivity!!.replaceFragment(LoginFragment(), R.id.frame_container)

    }
    companion object {

    }

    override fun onViewClick(view: View) {
        when (view.id) {
            R.id.loginTV -> {
                gotoLoginFragment()
            }
            R.id.signupTV -> {
               signuptutsFragment()
            }

        }

    }



}