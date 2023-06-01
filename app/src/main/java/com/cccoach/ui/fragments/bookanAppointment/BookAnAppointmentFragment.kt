package com.cccoach.ui.fragments.bookanAppointment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cccoach.R
import com.cccoach.databinding.FragmentBookAnAppointmentBinding
import com.cccoach.ui.adapter.ReviewAdapter.ReviewOfAppointmentAdapter
import com.cccoach.ui.base.BaseFragment
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.fragments.timebooking.TimeBookingFragment
import com.cccoach.utils.HandleClickListener


class BookAnAppointmentFragment : BaseFragment(),HandleClickListener{

    var binding:FragmentBookAnAppointmentBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (binding == null)
            binding = FragmentBookAnAppointmentBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {
        binding!!.handleClick=this
        val reviewOfAppointmentAdapter = ReviewOfAppointmentAdapter(requireContext())
        val linearLayoutManager = LinearLayoutManager(context)
        binding!!.reviewRCV.adapter = reviewOfAppointmentAdapter
        binding!!.reviewRCV.layoutManager = linearLayoutManager
    }

    override fun onViewClick(view: View) {
        when (view.id) {
            R.id.backIV -> {
                requireActivity().supportFragmentManager.popBackStack()
            }
            R.id.bookAppointmentACTV -> {
                baseActivity!!.replaceFragment(TimeBookingFragment(), R.id.frame_container)

            }


        }
    }


}