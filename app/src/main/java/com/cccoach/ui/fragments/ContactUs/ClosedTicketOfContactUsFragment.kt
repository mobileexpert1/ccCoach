package com.cccoach.ui.fragments.ContactUs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cccoach.R
import com.cccoach.databinding.FragmentClosedTicketOfContactUsBinding
import com.cccoach.databinding.FragmentContactUsBinding
import com.cccoach.ui.adapter.ContactUs.ContactUsAdapter
import com.cccoach.ui.adapter.Message.ChatMessageAdapter
import com.cccoach.ui.base.BaseFragment


class ClosedTicketOfContactUsFragment : BaseFragment() {

    var binding:FragmentClosedTicketOfContactUsBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null)
            binding = FragmentClosedTicketOfContactUsBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {

        val chatMessageAdapter = ChatMessageAdapter(requireContext())
        val linearLayoutManager = LinearLayoutManager(context)
        binding!!.rvChatMessage.adapter = chatMessageAdapter
        binding!!.rvChatMessage.layoutManager = linearLayoutManager
    }


}