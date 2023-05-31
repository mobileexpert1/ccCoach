package com.cccoach.ui.fragments.learner.sidemenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cccoach.R
import com.cccoach.databinding.FragmentSideMenuBinding
import com.cccoach.ui.activities.MainActivity
import com.cccoach.ui.base.BaseFragment
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.fragments.AboutUs.AboutUsFragment
import com.cccoach.ui.fragments.ChangePassword.ChangePasswordFragment
import com.cccoach.ui.fragments.ContactUs.ContactUsFragment
import com.cccoach.ui.fragments.FAQs.FAQsFragment
import com.cccoach.ui.fragments.PrivacyPolicy.PrivacyPolicyFragment
import com.cccoach.ui.fragments.TermsAndCondition.TermsAndConditionFragment
import com.cccoach.ui.fragments.Verification.VerificationFragment
import com.cccoach.ui.fragments.learner.favourite.FavouriteFragment
import com.cccoach.utils.HandleClickListener


class SideMenuFragment : BaseFragment(), HandleClickListener {

    var binding: FragmentSideMenuBinding? = null

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
            binding = FragmentSideMenuBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {
        binding!!.handleClick = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (baseActivity as MainActivity).setIcon()
        (baseActivity as MainActivity).setToolbar(
            baseActivity!!.getString(R.string.ll),
            isTitle = true, isToolbar = false, isBottom = true
        )

    }

    companion object {

    }

    override fun onViewClick(view: View) {
        when (view.id) {

            R.id.favouriteTV -> {
                gotoFavFragment()
            }
            R.id.changPasswordTV -> {
                gotochangePasswordFragment()
            }
            R.id.contactusTV -> {
                gotoContactUsFragment()
            }
            R.id.faqTV -> {
                gotoFaqFragment()
            }
            R.id.privacyPolicyTV -> {
                gotoprivacyPolicyFragment()
            }
            R.id.aboutusTV -> {
                gotoAboutUsFragment()
            }
            R.id.termsandconditionsTV -> {
                gotoTermConditionnFragment()
            }
            R.id.logOutIV -> {
                gotoLogout()
            }


        }
    }

    private fun gotoLogout() {
        TODO("Not yet implemented")
    }

    private fun gotoAboutUsFragment() {
        baseActivity!!.replaceFragment(AboutUsFragment(), R.id.frame_container)
    }

    private fun gotoprivacyPolicyFragment() {
        baseActivity!!.replaceFragment(PrivacyPolicyFragment(), R.id.frame_container)
    }

    private fun gotochangePasswordFragment() {
        baseActivity!!.replaceFragment(ChangePasswordFragment(), R.id.frame_container)
    }

    private fun gotoTermConditionnFragment() {
        baseActivity!!.replaceFragment(TermsAndConditionFragment(), R.id.frame_container)
    }

    private fun gotoFaqFragment() {
        baseActivity!!.replaceFragment(FAQsFragment(), R.id.frame_container)
    }

    private fun gotoContactUsFragment() {
        baseActivity!!.replaceFragment(ContactUsFragment(), R.id.frame_container)
    }

    private fun gotoFavFragment() {
        baseActivity!!.replaceFragment(FavouriteFragment(), R.id.frame_container)
    }
}