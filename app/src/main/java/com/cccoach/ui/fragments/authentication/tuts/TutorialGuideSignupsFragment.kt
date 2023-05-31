package com.cccoach.ui.fragments.authentication.tuts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cccoach.R
import com.cccoach.databinding.FragmentTutorialGuideLSBinding
import com.cccoach.databinding.FragmentTutorialGuideSignupsBinding
import com.cccoach.ui.base.BaseFragment
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.fragments.authentication.signup.SignupCoachFragment
import com.cccoach.ui.fragments.authentication.signup.SignupLearnerFragment
import com.cccoach.utils.HandleClickListener


class TutorialGuideSignupsFragment : BaseFragment(), HandleClickListener {

    var binding:FragmentTutorialGuideSignupsBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null)
            binding = FragmentTutorialGuideSignupsBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    companion object {

    }

    private fun initUI() {
        binding!!.handleClick = this
    }


    private fun gotoCoachFragment(){
        baseActivity!!.replaceFragment(SignupCoachFragment(), R.id.frame_container)
    }

    private fun gotoLearnerFragment(){
        baseActivity!!.replaceFragment(SignupLearnerFragment(), R.id.frame_container)
    }


    override fun onViewClick(view: View) {
        when (view.id) {
            R.id.coachSignupTV -> {
                gotoCoachFragment()
            }
            R.id.learnerSignupTV -> {
                gotoLearnerFragment()
            }
        }
    }
}