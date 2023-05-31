package com.cccoach.ui.fragments.FindACoach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cccoach.R
import com.cccoach.databinding.FragmentFindACoachBinding
import com.cccoach.ui.base.BaseFragment
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.fragments.learner.coaches.CoachesFragment
import com.cccoach.utils.HandleClickListener


class FindACoachFragment : BaseFragment(),HandleClickListener {

    var binding:FragmentFindACoachBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null)
            binding = FragmentFindACoachBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {

        binding!!.handleClick=this
    }

    override fun onViewClick(view: View) {

        when (view.id) {
            R.id.ivBackpress->{
                requireActivity().supportFragmentManager.popBackStack()
            }
            R.id.findCoachesTV->{
                gotoCoaches()
            }
        }
    }

    private fun gotoCoaches() {
        baseActivity!!.replaceFragment(CoachesFragment(), R.id.frame_container)
    }

}