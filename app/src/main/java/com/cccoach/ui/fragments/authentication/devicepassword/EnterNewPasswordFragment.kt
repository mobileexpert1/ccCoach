package com.cccoach.ui.fragments.devicepassword

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.cccoach.R
import com.cccoach.databinding.FragmentEnterNewPasswordBinding
import com.cccoach.databinding.FragmentForgotPasswordBinding
import com.cccoach.ui.base.BaseFragment
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.fragments.authentication.login.LoginFragment
import com.cccoach.ui.fragments.Learner.home.HomeFragment
import com.cccoach.utils.Const
import com.cccoach.utils.HandleClickListener


class EnterNewPasswordFragment : BaseFragment(),HandleClickListener{

    var binding:FragmentEnterNewPasswordBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null)
            binding = FragmentEnterNewPasswordBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {
        binding!!.handleClick=this
    }

    override fun onViewClick(view: View) {
        when (view.id) {
            R.id.enterdevicePasswordcontiuneTV -> {



                var dialog = Dialog(baseActivity!!,R.style.CustomBottomSheetDialogTheme)
                dialog.setCancelable(true)
                dialog.setContentView(R.layout.no_touch_id_popup)
                val dialogLL = dialog.findViewById(R.id.touchLL) as LinearLayout
                dialogLL.setOnClickListener {
                    dialog.dismiss()
                }
                val contiuneLinearLayout = dialog.findViewById(R.id.contiuneLL) as LinearLayout
                contiuneLinearLayout.setOnClickListener {
                    baseActivity!!.gotMainActivity()
                }
                dialog.show()

            }
            R.id.backIV->{
                requireActivity().supportFragmentManager.popBackStack()
            }

        }
    }


}