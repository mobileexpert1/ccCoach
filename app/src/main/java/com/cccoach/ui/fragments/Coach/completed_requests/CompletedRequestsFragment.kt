package com.cccoach.ui.fragments.Coach.completed_requests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.cccoach.R
import com.cccoach.databinding.FragmentCompletedRequestsBinding
import com.cccoach.ui.adapter.CompletedRequest.CompletedRequestAdapter
import com.cccoach.ui.base.BaseFragment
import com.cccoach.utils.HandleClickListener


class CompletedRequestsFragment : BaseFragment(), HandleClickListener,CompletedRequestAdapter.ClickListeners {

    var binding : FragmentCompletedRequestsBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (binding == null)  binding = FragmentCompletedRequestsBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {
        binding!!.handleClick=this
        val rvCompletedRequestList = binding!!.rvCompletedRequestList
        val completedRequestAdapter = CompletedRequestAdapter(requireContext(),this)
        val linearLayoutManager = LinearLayoutManager(context)
        rvCompletedRequestList.adapter = completedRequestAdapter
        rvCompletedRequestList.layoutManager = linearLayoutManager
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