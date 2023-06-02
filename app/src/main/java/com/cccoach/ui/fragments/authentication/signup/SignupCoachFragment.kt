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
import com.cccoach.ui.base.BaseFragment
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.fragments.authentication.login.LoginFragment
import com.cccoach.utils.Const
import com.cccoach.utils.HandleClickListener


class SignupCoachFragment : BaseFragment(),HandleClickListener {

    var binding:FragmentSignupCoachBinding?=null
    var passwordvisible = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (binding == null)
            binding = FragmentSignupCoachBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {
        binding?.handleClick = this
    }

    companion object {


    }

    override fun onViewClick(view: View) {

        when (view.id) {
            R.id.continueAsaCoachTV -> {
                if (binding!!.nameET.text!!.isEmpty()) {
                    showShortToast("Please enter Name.")
                }else if (binding!!.signupCoachEmailET.text!!.isEmpty()){
                    showShortToast("Please enter Email.")
                } else if (!isEmailValid(binding!!.signupCoachEmailET.text.toString())) {
                    showShortToast("Please enter valid email.")
                } else if (binding!!.signupCoachPasswordET.text!!.isEmpty()) {
                    showShortToast("Please enter password.")
                }/*else if (!isValidPassword(binding!!.signupCoachPasswordET.text.toString())) {
                    showShortToast("Please enter valid password")
                }*/ else if (binding!!.signupCoachconfirmpasswordET.text!!.isEmpty()) {
                    showShortToast("Please enter confirm password.")
                } /*else if (!isValidPassword(binding!!.signupCoachconfirmpasswordET.text.toString())) {
                    showShortToast("Please enter valid confirm password")
                }*/else if (binding!!.sigupCoachCountryET.text!!.isEmpty()){
                    showShortToast("Please enter country.")
                }else if (binding!!.signupCoachAddressET.text!!.isEmpty()){
                    showShortToast("Please enter address.")
                }else if (binding!!.signupDobET.text.isEmpty()){
                    showShortToast("Please enter DOB.")
                }else if (binding!!.signupCoachWWCET.text.isEmpty()){
                    showShortToast("Please enter WWC number.")
                }else if (binding!!.signupCoachLicenceNumET.text.isEmpty()){
                    showShortToast("Please enter Nsw driver's licence number.")
                } else {
                    val dialog = Dialog(baseActivity!!,R.style.CustomBottomSheetDialogTheme)
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
            R.id.coachLoginTV -> {
                baseActivity!!.replaceFragment(LoginFragment(), R.id.frame_container)
            }
            R.id.backIV -> {
                requireActivity().supportFragmentManager.popBackStack()
            }
            R.id.passwordsetEyeImv -> {
                    binding!!.passwordsetEyeImv.setOnClickListener(object : View.OnClickListener {
                        override fun onClick(view: View?) {
                            if (!passwordvisible) {
                                binding!!.signupCoachPasswordET.setTransformationMethod(
                                    PasswordTransformationMethod.getInstance())
                                passwordvisible = true
                                binding!!.signupCoachPasswordET.setSelection(binding!!.signupCoachPasswordET.getText().length)
                                binding!!.passwordsetEyeImv.setImageResource(R.drawable.ic_hide)
                            } else {
                                binding!!.signupCoachPasswordET.setTransformationMethod(
                                    HideReturnsTransformationMethod.getInstance())
                                passwordvisible = false
                                binding!!.signupCoachPasswordET.setSelection(binding!!.signupCoachPasswordET.getText().length)
                                binding!!.passwordsetEyeImv.setImageResource(R.drawable.ic_show)
                            }
                        }
                    })
                }
            R.id.confirmpasswordsetEyeImv -> {

                    binding!!.confirmpasswordsetEyeImv.setOnClickListener(object : View.OnClickListener {
                        override fun onClick(view: View?) {
                            if (!passwordvisible) {
                                binding!!.signupCoachconfirmpasswordET.setTransformationMethod(
                                    PasswordTransformationMethod.getInstance())
                                passwordvisible = true
                                binding!!.signupCoachconfirmpasswordET.setSelection(binding!!.signupCoachconfirmpasswordET.getText().length)
                                binding!!.confirmpasswordsetEyeImv.setImageResource(R.drawable.ic_hide)
                            } else {
                                binding!!.signupCoachconfirmpasswordET.setTransformationMethod(
                                    HideReturnsTransformationMethod.getInstance())
                                passwordvisible = false
                                binding!!.signupCoachconfirmpasswordET.setSelection(binding!!.signupCoachconfirmpasswordET.getText().length)
                                binding!!.confirmpasswordsetEyeImv.setImageResource(R.drawable.ic_show)
                            }
                        }
                    })
                }



            }

    }


}