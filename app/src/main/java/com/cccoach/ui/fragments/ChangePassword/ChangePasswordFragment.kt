package com.cccoach.ui.fragments.ChangePassword

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cccoach.R
import com.cccoach.databinding.FragmentChangePasswordBinding
import com.cccoach.databinding.FragmentSideMenuBinding
import com.cccoach.ui.activities.MainActivity
import com.cccoach.ui.base.BaseFragment
import com.cccoach.utils.HandleClickListener


class ChangePasswordFragment : BaseFragment(),HandleClickListener {

    var binding:FragmentChangePasswordBinding?=null
    var passwordvisible = false
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
        //Bottom navigation hide

        (baseActivity as MainActivity).setIcon()
        (baseActivity as MainActivity).setToolbar(
            baseActivity!!.getString(R.string.ll),
            isTitle = true, isToolbar = false, isBottom = false
        )
    }

    override fun onViewClick(view: View) {
        when (view.id) {

            R.id.ivBackpress -> {
                requireActivity().supportFragmentManager.popBackStack()
            }
            R.id.passwordsetEyeImv -> {
                binding!!.passwordsetEyeImv.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(view: View?) {
                        if (!passwordvisible) {
                            binding!!.oldpasswordET.setTransformationMethod(
                                PasswordTransformationMethod.getInstance())
                            passwordvisible = true
                            binding!!.oldpasswordET.setSelection(binding!!.oldpasswordET.getText().length)
                            binding!!.passwordsetEyeImv.setImageResource(R.drawable.ic_hide)
                        } else {
                            binding!!.oldpasswordET.setTransformationMethod(
                                HideReturnsTransformationMethod.getInstance())
                            passwordvisible = false
                            binding!!.oldpasswordET.setSelection(binding!!.oldpasswordET.getText().length)
                            binding!!.passwordsetEyeImv.setImageResource(R.drawable.ic_show)
                        }
                    }
                })

            }

            R.id.newpasswordEyeImv -> {
                binding!!.newpasswordEyeImv.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(view: View?) {
                        if (!passwordvisible) {
                            binding!!.newpasswordET.setTransformationMethod(
                                PasswordTransformationMethod.getInstance())
                            passwordvisible = true
                            binding!!.newpasswordET.setSelection(binding!!.newpasswordET.getText().length)
                            binding!!.newpasswordEyeImv.setImageResource(R.drawable.ic_hide)
                        } else {
                            binding!!.newpasswordET.setTransformationMethod(
                                HideReturnsTransformationMethod.getInstance())
                            passwordvisible = false
                            binding!!.newpasswordET.setSelection(binding!!.newpasswordET.getText().length)
                            binding!!.newpasswordEyeImv.setImageResource(R.drawable.ic_show)
                        }
                    }
                })

            }

            R.id.confirmpasswordEyeImv -> {
                binding!!.confirmpasswordEyeImv.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(view: View?) {
                        if (!passwordvisible) {
                            binding!!.confirmpasswordET.setTransformationMethod(
                                PasswordTransformationMethod.getInstance())
                            passwordvisible = true
                            binding!!.confirmpasswordET.setSelection(binding!!.confirmpasswordET.getText().length)
                            binding!!.confirmpasswordEyeImv.setImageResource(R.drawable.ic_hide)
                        } else {
                            binding!!.confirmpasswordET.setTransformationMethod(
                                HideReturnsTransformationMethod.getInstance())
                            passwordvisible = false
                            binding!!.confirmpasswordET.setSelection(binding!!.confirmpasswordET.getText().length)
                            binding!!.confirmpasswordEyeImv.setImageResource(R.drawable.ic_show)
                        }
                    }
                })
            }
        }
    }

}