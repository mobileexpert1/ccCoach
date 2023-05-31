package com.cccoach.ui.fragments.coach.completed_requests

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.cccoach.R
import com.cccoach.databinding.FragmentCompletedRequestsBinding
import com.cccoach.databinding.FragmentMyRequestBinding
import com.cccoach.ui.adapter.learner.CoachAdapter
import com.cccoach.ui.base.BaseFragment
import com.cccoach.utils.HandleClickListener


class CompletedRequestsFragment : BaseFragment(), HandleClickListener,CoachAdapter.ClickListeners {

    var binding : FragmentCompletedRequestsBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        if (binding == null)  binding = FragmentCompletedRequestsBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {
        binding!!.handleClick=this
        val rvCoachList = binding!!.rvCoachList
        val coachAdapter = CoachAdapter(requireContext(),this)
        val linearLayoutManager = LinearLayoutManager(context)
        rvCoachList.adapter = coachAdapter
        rvCoachList.layoutManager = linearLayoutManager
    }

    override fun onViewClick(view: View) {
        when(view.id) {
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