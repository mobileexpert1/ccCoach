package com.cccoach.ui.fragments.authentication.signup

import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
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

    var passwordvisible = false
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
                if (binding!!.learnerNameET.text!!.isEmpty()) {
                    showShortToast("Please enter Name.")
                }else if (binding!!.signupLearnerEmailET.text!!.isEmpty()){
                    showShortToast("Please enter Email.")
                } else if (!isEmailValid(binding!!.signupLearnerEmailET.text.toString())) {
                    showShortToast("Please enter valid email.")
                } else if (binding!!.signupLearnerPasswordET.text!!.isEmpty()) {
                    showShortToast("Please enter password.")
                }/*else if (!isValidPassword(binding!!.signupLearnerPasswordET.text.toString())) {
                    showShortToast("Please enter valid password")
                }*/ else if (binding!!.signupLearnerconfirmpasswordET.text!!.isEmpty()) {
                    showShortToast("Please enter confirm password.")
                } /*else if (!isValidPassword(binding!!.signupLearnerconfirmpasswordET.text.toString())) {
                    showShortToast("Please enter valid confirm password")
                }*/else if (binding!!.sigupLearnerCountryET.text!!.isEmpty()){
                    showShortToast("Please enter country.")
                }else if (binding!!.signupLearnerAddressET.text!!.isEmpty()){
                    showShortToast("Please enter address.")
                }else if (binding!!.signupLearnerDobET.text.isEmpty()){
                    showShortToast("Please enter DOB.")
                }else if (binding!!.signupLearnerLicenceNumET.text.isEmpty()){
                    showShortToast("Please enter Nsw driver's licence number.")
                }else {

                    var dialog = Dialog(baseActivity!!, R.style.CustomBottomSheetDialogTheme)
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
            }
            R.id.loginTV -> {
                baseActivity!!.replaceFragment(LoginFragment(), R.id.frame_container)

            }
            R.id.backIV -> {
                requireActivity().supportFragmentManager.popBackStack()
            }


            R.id.passwordsetEyeImv -> {

                binding!!.passwordsetEyeImv.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(view: View?) {
                        if (!passwordvisible) {
                            binding!!.signupLearnerPasswordET.setTransformationMethod(
                                PasswordTransformationMethod.getInstance())
                            passwordvisible = true
                            binding!!.signupLearnerPasswordET.setSelection(binding!!.signupLearnerPasswordET.getText().length)
                            binding!!.passwordsetEyeImv.setImageResource(R.drawable.ic_hide)
                        } else {
                            binding!!.signupLearnerPasswordET.setTransformationMethod(
                                HideReturnsTransformationMethod.getInstance())
                            passwordvisible = false
                            binding!!.signupLearnerPasswordET.setSelection(binding!!.signupLearnerPasswordET.getText().length)
                            binding!!.passwordsetEyeImv.setImageResource(R.drawable.ic_show)
                        }
                    }
                })
            }
            R.id.confirmpasswordsetEyeImv -> {

                binding!!.confirmpasswordsetEyeImv.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(view: View?) {
                        if (!passwordvisible) {
                            binding!!.signupLearnerconfirmpasswordET.setTransformationMethod(
                                PasswordTransformationMethod.getInstance())
                            passwordvisible = true
                            binding!!.signupLearnerconfirmpasswordET.setSelection(binding!!.signupLearnerconfirmpasswordET.getText().length)
                            binding!!.confirmpasswordsetEyeImv.setImageResource(R.drawable.ic_hide)
                        } else {
                            binding!!.signupLearnerconfirmpasswordET.setTransformationMethod(
                                HideReturnsTransformationMethod.getInstance())
                            passwordvisible = false
                            binding!!.signupLearnerconfirmpasswordET.setSelection(binding!!.signupLearnerconfirmpasswordET.getText().length)
                            binding!!.confirmpasswordsetEyeImv.setImageResource(R.drawable.ic_show)
                        }
                    }
                })
            }

            R.id.learnerLoginTV -> {
                baseActivity!!.replaceFragment(LoginFragment(), R.id.frame_container)
            }

        }
    }
}