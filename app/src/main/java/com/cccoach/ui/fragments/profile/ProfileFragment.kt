package com.cccoach.ui.fragments.profile

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.cccoach.R
import com.cccoach.databinding.FragmentProfileBinding
import com.cccoach.ui.activities.MainActivity
import com.cccoach.ui.adapter.learner.CoachAdapter
import com.cccoach.ui.base.BaseFragment
import com.cccoach.utils.HandleClickListener
import com.google.android.material.bottomsheet.BottomSheetDialog


class ProfileFragment :BaseFragment(),HandleClickListener,CoachAdapter.ClickListeners{

    var binding: FragmentProfileBinding?=null

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
            binding = FragmentProfileBinding.inflate(inflater, container, false)
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
        val postBookingRCv = binding!!.postBookingRCv
        val coachAdapter = CoachAdapter(requireContext(),this)
        val linearLayoutManager = LinearLayoutManager(context)
        postBookingRCv.adapter = coachAdapter
        postBookingRCv.layoutManager = linearLayoutManager
    }

    companion object {

    }

    override fun onViewClick(view: View) {
        when (view.id) {
            R.id.forgotcontinueTV -> {
            }
            R.id.ivBackpress->{
                requireActivity().supportFragmentManager.popBackStack()
            }
            R.id.editImv->{
                gotoEditProfile()
            }

        }
    }

    private fun gotoEditProfile() {

        val dialog = BottomSheetDialog(requireContext(), R.style.CustomBottomSheetDialogTheme)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.edit_personal_info_dialog)
        dialog.show()
        val window = dialog.window
        window!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#00FFFFFF")))
        window.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        window.setGravity(Gravity.BOTTOM)

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
        window.setGravity(Gravity.BOTTOM)

    }


}