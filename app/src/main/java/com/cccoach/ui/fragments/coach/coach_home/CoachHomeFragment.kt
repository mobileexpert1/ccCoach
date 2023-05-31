package com.cccoach.ui.fragments.coach.coach_home

import android.content.res.Resources.Theme
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.cccoach.R
import com.cccoach.databinding.FragmentCoachHomeBinding
import com.cccoach.ui.adapter.learner.CoachAdapter
import com.cccoach.ui.base.BaseFragment
import com.cccoach.utils.HandleClickListener


class CoachHomeFragment : BaseFragment(), HandleClickListener,CoachAdapter.ClickListeners {

    var binding : FragmentCoachHomeBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        if (binding == null)  binding = FragmentCoachHomeBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {
        val rvCoachList = binding!!.rvCoachList
        val coachAdapter = CoachAdapter(requireContext(),this)
        val linearLayoutManager = LinearLayoutManager(context)
        rvCoachList.adapter = coachAdapter
        rvCoachList.layoutManager = linearLayoutManager
    }

    private fun unselectAllTabs() {
        binding!!.tvAccepted.background = ContextCompat.getDrawable(requireActivity(), R.drawable.bg_light_gray)
        binding!!.tvAccepted.setTextColor(Color.BLACK)
        binding!!.tvPending.background = ContextCompat.getDrawable(requireActivity(), R.drawable.bg_light_gray)
        binding!!.tvPending.setTextColor(Color.BLACK)
        binding!!.tvDeclined.background = ContextCompat.getDrawable(requireActivity(), R.drawable.bg_light_gray)
        binding!!.tvDeclined.setTextColor(Color.BLACK)
    }

    override fun onViewClick(view: View) {
        when(view.id) {
            R.id.tvAccepted -> {
                unselectAllTabs()
                binding!!.tvAccepted.background = ContextCompat.getDrawable(requireActivity(), R.drawable.darkblue_rect)
                binding!!.tvAccepted.setTextColor(Color.WHITE)
            }
            R.id.tvPending -> {
                unselectAllTabs()
                binding!!.tvPending.background = ContextCompat.getDrawable(requireActivity(), R.drawable.darkblue_rect)
                binding!!.tvPending.setTextColor(Color.WHITE)
            }
            R.id.tvDeclined -> {
                unselectAllTabs()
                binding!!.tvDeclined.background = ContextCompat.getDrawable(requireActivity(), R.drawable.darkblue_rect)
                binding!!.tvDeclined.setTextColor(Color.WHITE)
            }
            R.id.tvAvailable -> {
                binding!!.tvOffline.background = ContextCompat.getDrawable(requireActivity(), R.drawable.bg_gray)
                binding!!.tvAvailable.background = ContextCompat.getDrawable(requireActivity(), R.drawable.darkblue_rect)
            }
            R.id.tvOffline -> {
                binding!!.tvAvailable.background = ContextCompat.getDrawable(requireActivity(), R.drawable.bg_gray)
                binding!!.tvOffline.background = ContextCompat.getDrawable(requireActivity(), R.drawable.darkblue_rect)
            }
        }
    }

    override fun onclick(position: Int) {



    }

}