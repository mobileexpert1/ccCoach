package com.cccoach.ui.fragments.ChangePassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cccoach.R
import com.cccoach.databinding.FragmentChangePasswordBinding
import com.cccoach.databinding.FragmentSideMenuBinding
import com.cccoach.ui.base.BaseFragment
import com.cccoach.utils.HandleClickListener


class ChangePasswordFragment : BaseFragment(),HandleClickListener {

    var binding:FragmentChangePasswordBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null)
            binding = FragmentChangePasswordBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {
       binding!!.handleClick=this
    }

    override fun onViewClick(view: View) {
        when (view.id) {

            R.id.ivBackpress -> {
                requireActivity().supportFragmentManager.popBackStack()
            }
            R.id.saveTV -> {

            }
        }
    }

}