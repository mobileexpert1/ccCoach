package com.cccoach.ui.fragments.Learner.myrequest

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.cccoach.R
import com.cccoach.databinding.FragmentMyRequestBinding
import com.cccoach.ui.activities.MainActivity
import com.cccoach.ui.adapter.learner.CoachAdapter
import com.cccoach.ui.base.BaseFragment
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.fragments.profile.ProfileFragment
import com.cccoach.utils.HandleClickListener
import com.google.android.material.bottomsheet.BottomSheetDialog


class MyRequestFragment : BaseFragment(), HandleClickListener,CoachAdapter.ClickListeners {

    var binding : FragmentMyRequestBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (binding == null)
            binding = FragmentMyRequestBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {
        binding!!.handleClick=this

        //Bottom navigation hide
        (baseActivity as MainActivity).setIcon()
        (baseActivity as MainActivity).setToolbar(
            baseActivity!!.getString(R.string.ll),
            isTitle = true, isToolbar = false, isBottom = true
        )
        val rvCoachList = binding!!.rvCoachList
        val coachAdapter = CoachAdapter(requireContext(),this)
        val linearLayoutManager = LinearLayoutManager(context)
        rvCoachList.adapter = coachAdapter
        rvCoachList.layoutManager = linearLayoutManager
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (baseActivity as MainActivity).setIcon()

    }

    private fun unselectAllTabs() {
        binding!!.tvAccepted.background = ContextCompat.getDrawable(requireActivity(), R.drawable.bg_light_gray)
        binding!!.tvAccepted.setTextColor(Color.BLACK)
        binding!!.tvPending.background = ContextCompat.getDrawable(requireActivity(), R.drawable.bg_light_gray)
        binding!!.tvPending.setTextColor(Color.BLACK)
        binding!!.tvDeclined.background = ContextCompat.getDrawable(requireActivity(), R.drawable.bg_light_gray)
        binding!!.tvDeclined.setTextColor(Color.BLACK)
        binding!!.tvCompleted.background = ContextCompat.getDrawable(requireActivity(), R.drawable.bg_light_gray)
        binding!!.tvCompleted.setTextColor(Color.BLACK)
    }

    private fun gotoProfile() {
        baseActivity!!.replaceFragment(ProfileFragment(), R.id.frame_container)

    }

    override fun onViewClick(view: View) {
        when(view.id) {

            R.id.tvAccepted -> {
                unselectAllTabs()
                binding!!.tvAccepted.background = ContextCompat.getDrawable(requireActivity(), R.drawable.darkblue_rect)
                binding!!.tvAccepted.setTextColor(Color.WHITE)
            }
            R.id.tvPending -> {
                unselectAllTabs()
                binding!!.tvPending.background = ContextCompat.getDrawable(requireActivity(), R.drawable.darkblue_rect)
                binding!!.tvPending.setTextColor(Color.WHITE)
            }
            R.id.tvDeclined -> {
                unselectAllTabs()
                binding!!.tvDeclined.background = ContextCompat.getDrawable(requireActivity(), R.drawable.darkblue_rect)
                binding!!.tvDeclined.setTextColor(Color.WHITE)
            }
            R.id.tvCompleted -> {
                unselectAllTabs()
                binding!!.tvCompleted.background = ContextCompat.getDrawable(requireActivity(), R.drawable.darkblue_rect)
                binding!!.tvCompleted.setTextColor(Color.WHITE)
            }
            R.id.ivLogo->{
                gotoProfile()
            }

        }


    }

    override fun onclick(position: Int) {
        val dialog = BottomSheetDialog(requireContext(), R.style.CustomBottomSheetDialogTheme)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.average_ratings_with_review_sheet)
        dialog.show()
        val window = dialog.window
        window!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#00FFFFFF")))
        window.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        window.setGravity(Gravity.BOTTOM)

    }


}