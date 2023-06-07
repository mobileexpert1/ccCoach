package com.cccoach.ui.fragments.Learner.home

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.cccoach.R
import com.cccoach.databinding.FragmentHomeBinding
import com.cccoach.ui.activities.MainActivity
import com.cccoach.ui.adapter.HomeCoachList.HomeCoachListAdapter
import com.cccoach.ui.adapter.learner.SessionAdapter
import com.cccoach.ui.base.BaseFragment
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.fragments.FindACoach.FindACoachFragment
import com.cccoach.ui.fragments.profile.ProfileFragment
import com.cccoach.utils.HandleClickListener
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle
class HomeFragment : BaseFragment(), HandleClickListener, HomeCoachListAdapter.ClickListeners {
    var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (binding == null)
            binding = FragmentHomeBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {
        binding!!.handleClick = this
        bottomSheetRemove()

        /*
        * List Binding
        * */
        val vpSessions = binding!!.vpSessions
        val rvHomeCoachList = binding!!.rvHomeCoachList

        /*
        * Session Adapter
        * */
        val viewPager2Adapter = SessionAdapter(requireContext())
        vpSessions.setPadding(20, 5, 20, 5)
        vpSessions.setAdapter(viewPager2Adapter)

        val indicatorView = binding!!.indicatorsSession
        indicatorView.apply {
            setIndicatorStyle(IndicatorStyle.ROUND_RECT)
            setSlideMode(IndicatorSlideMode.NORMAL)
            setSliderHeight(resources.getDimension(com.intuit.sdp.R.dimen._3sdp))
            setSliderWidth(resources.getDimension(com.intuit.sdp.R.dimen._40sdp))
            setSliderColor(resources.getColor(R.color.gray), resources.getColor(R.color.dark_blue))
            setupWithViewPager(vpSessions)

        }

        /*
        * Home Cach List Adapter
        * */

        val homeCoachListAdapter = HomeCoachListAdapter(requireContext(), this)
        val linearLayoutManager = LinearLayoutManager(context)
        rvHomeCoachList.adapter = homeCoachListAdapter
        rvHomeCoachList.layoutManager = linearLayoutManager

    }

    private fun bottomSheetRemove() {
        (baseActivity as MainActivity).setIcon()
        (baseActivity as MainActivity).setToolbar(
            baseActivity!!.getString(R.string.ll),
            isTitle = true, isToolbar = false, isBottom = true
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onViewClick(view: View) {
        when (view.id) {
            R.id.ivLogoHome -> {
                gotoProfile()
            }
            R.id.findACoachCL -> {
                gotoFindaACoach()
            }
        }
    }

    private fun gotoFindaACoach() {
        baseActivity!!.replaceFragment(FindACoachFragment(), R.id.frame_container)
    }

    private fun gotoProfile() {
        baseActivity!!.replaceFragment(ProfileFragment(), R.id.frame_container)

    }

    override fun onclick(position: Int) {
        val dialog = BottomSheetDialog(requireContext(), R.style.CustomBottomSheetDialogTheme)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.average_ratings_bottom_sheet)
        dialog.show()
        val window = dialog.window
        window!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#00FFFFFF")))
        window.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        val rateLL = dialog.findViewById<LinearLayout>(R.id.bottomsheetRateLL)
        rateLL!!.setOnClickListener {

            val dialogRate = Dialog(baseActivity!!,R.style.CustomBottomSheetDialogTheme)
            dialogRate.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialogRate.setCancelable(true)
            dialogRate.setContentView(R.layout.ratecoach_dialog_box)
            val rateLinearLayout = dialogRate.findViewById<LinearLayout>(R.id.rateCoachClickLL)
            rateLinearLayout.setOnClickListener {
                dialogRate.dismiss()
            }
            dialogRate.show()
        }

    }

}