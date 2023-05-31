package com.cccoach.ui.fragments.PrivacyPolicy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cccoach.R
import com.cccoach.databinding.FragmentPrivacyPolicyBinding
import com.cccoach.databinding.FragmentSideMenuBinding
import com.cccoach.ui.base.BaseFragment
import com.cccoach.utils.HandleClickListener


class PrivacyPolicyFragment : BaseFragment(),HandleClickListener {


    var binding:FragmentPrivacyPolicyBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null)
            binding = FragmentPrivacyPolicyBinding.inflate(inflater, container, false)
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
        }
    }

}