package com.cccoach.ui.fragments.authentication.signup

import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import com.cccoach.R
import com.cccoach.databinding.FragmentSignupCoachBinding
import com.cccoach.databinding.FragmentSignupLearnerBinding
import com.cccoach.ui.base.BaseFragment
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.fragments.authentication.login.LoginFragment
import com.cccoach.utils.Const
import com.cccoach.utils.HandleClickListener


class SignupLearnerFragment : BaseFragment(),HandleClickListener {


    var binding:FragmentSignupLearnerBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null)
            binding = FragmentSignupLearnerBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
        // Inflate the layout for this fragment
    }

    private fun initUI() {
        binding?.handleClick = this
    }

    companion object {

    }



    override fun onViewClick(view: View) {
        when (view.id) {
            R.id.continueAsaLearnerTV -> {
                var dialog = Dialog(baseActivity!!,R.style.CustomBottomSheetDialogTheme)
                dialog.setCancelable(true)
                dialog.setContentView(R.layout.create_account_successfully_popup)
                val dialogLL = dialog.findViewById(R.id.dialogLL) as LinearLayout
                dialogLL.setOnClickListener {
                    dialog.dismiss()
                }
                dialog.show()
                val handler = Handler()
                handler.postDelayed({
                    dialog.dismiss()
                    baseActivity!!.replaceFragment(LoginFragment(), R.id.frame_container)
                }, Const.SPLASH_TIMEOUT.toLong())

            }
            R.id.loginTV -> {
                baseActivity!!.replaceFragment(LoginFragment(), R.id.frame_container)

            }
        }
    }
}