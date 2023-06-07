package com.cccoach.ui.fragments.ContactUs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cccoach.R
import com.cccoach.databinding.FragmentClosedTicketOfContactUsBinding
import com.cccoach.ui.activities.MainActivity
import com.cccoach.ui.adapter.ContactUs.ContactUsAdapter
import com.cccoach.ui.adapter.Message.ChatMessageAdapter
import com.cccoach.ui.base.BaseFragment
import com.cccoach.utils.HandleClickListener


class ClosedTicketOfContactUsFragment : BaseFragment(),HandleClickListener, ContactUsAdapter.ClickListeners {

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

        binding!!.handleClick=this
        //Bottom navigation hide
        (baseActivity as MainActivity).setIcon()
        (baseActivity as MainActivity).setToolbar(
            baseActivity!!.getString(R.string.ll),
            isTitle = true, isToolbar = false, isBottom = false
        )

        val chatMessageAdapter = ChatMessageAdapter(requireContext())
        val linearLayoutManager = LinearLayoutManager(context)
        binding!!.rvChatMessage.adapter = chatMessageAdapter
        binding!!.rvChatMessage.layoutManager = linearLayoutManager
    }

    override fun onclick(position: Int) {

    }

    override fun onViewClick(view: View) {

        when (view.id) {
            R.id.ivBackpress -> {
                baseActivity!!.onBackPressed()

            }
        }
    }


}