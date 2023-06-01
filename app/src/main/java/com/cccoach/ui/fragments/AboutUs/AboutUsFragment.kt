package com.cccoach.ui.fragments.AboutUs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cccoach.R
import com.cccoach.databinding.FragmentAboutUsBinding
import com.cccoach.databinding.FragmentSideMenuBinding
import com.cccoach.ui.activities.MainActivity
import com.cccoach.ui.base.BaseFragment
import com.cccoach.utils.HandleClickListener


class AboutUsFragment :BaseFragment(),HandleClickListener {

    var binding:FragmentAboutUsBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null)
            binding = FragmentAboutUsBinding.inflate(inflater, container, false)
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
    }

    override fun onViewClick(view: View) {
        when (view.id) {
            R.id.ivBackpress-> {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
    }

}