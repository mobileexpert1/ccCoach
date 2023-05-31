package com.cccoach.ui.fragments.ContactUs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cccoach.R
import com.cccoach.databinding.FragmentContactUsBinding
import com.cccoach.ui.adapter.ContactUs.ContactUsAdapter
import com.cccoach.ui.base.BaseFragment
import com.cccoach.utils.HandleClickListener

class ContactUsFragment : BaseFragment(),HandleClickListener {
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
        val contactUsAdapter = ContactUsAdapter(requireContext())
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

}