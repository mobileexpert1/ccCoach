package com.cccoach.ui.fragments.ContactUs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cccoach.R
import com.cccoach.databinding.FragmentContactUsBinding
import com.cccoach.ui.activities.MainActivity
import com.cccoach.ui.adapter.ContactUs.ContactUsAdapter
import com.cccoach.ui.adapter.Message.ChatMessageAdapter
import com.cccoach.ui.adapter.learner.CoachAdapter
import com.cccoach.ui.base.BaseFragment
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.fragments.FindACoach.FindACoachFragment
import com.cccoach.ui.fragments.bookanAppointment.BookAnAppointmentFragment
import com.cccoach.utils.HandleClickListener

class ContactUsFragment : BaseFragment(),HandleClickListener , ContactUsAdapter.ClickListeners{
    var binding:FragmentContactUsBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null)
            binding = FragmentContactUsBinding.inflate(inflater, container, false)
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
        val contactUsAdapter = ContactUsAdapter(requireContext(),this)
        val linearLayoutManager = LinearLayoutManager(context)
        binding!!.contactUsRCV.adapter = contactUsAdapter
        binding!!.contactUsRCV.layoutManager = linearLayoutManager
    }

    override fun onViewClick(view: View) {
        when (view.id) {
            R.id.ivBackpress->{
                requireActivity().supportFragmentManager.popBackStack()
            }

        }


    }

    override fun onclick(position: Int) {
        baseActivity!!.replaceFragment(ClosedTicketOfContactUsFragment(), R.id.frame_container)
    }

}