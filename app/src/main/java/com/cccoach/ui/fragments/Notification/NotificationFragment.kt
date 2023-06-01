package com.cccoach.ui.fragments.Notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cccoach.R
import com.cccoach.databinding.FragmentNotificationBinding
import com.cccoach.ui.adapter.NotificationAdapter.NotificationAdapter
import com.cccoach.ui.base.BaseFragment
import com.cccoach.utils.HandleClickListener

class NotificationFragment :BaseFragment(),HandleClickListener{

    var binding:FragmentNotificationBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null)
            binding = FragmentNotificationBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {
        binding!!.handleClick=this
        val notificationAdapter = NotificationAdapter(requireContext())
        val linearLayoutManager = LinearLayoutManager(context)
        binding!!.notificationRCV.adapter = notificationAdapter
        binding!!.notificationRCV.layoutManager = linearLayoutManager
    }

    override fun onViewClick(view: View) {
        when (view.id) {
            R.id.ivBackpress->{
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
    }


}