package com.cccoach.ui.fragments.profile

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.cccoach.R
import com.cccoach.databinding.FragmentProfileBinding
import com.cccoach.ui.activities.MainActivity
import com.cccoach.ui.adapter.PastBooking.PastBookingAdapter
import com.cccoach.ui.base.BaseFragment
import com.cccoach.utils.HandleClickListener
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog


class ProfileFragment :BaseFragment(),HandleClickListener,PastBookingAdapter.ClickListeners{

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
        val postBookingRCV = binding!!.postBookingRCV
        val pastBookingAdapter = PastBookingAdapter(requireContext(),this)
        val linearLayoutManager = LinearLayoutManager(context)
        postBookingRCV.adapter = pastBookingAdapter
        postBookingRCV.layoutManager = linearLayoutManager
    }

    companion object {

    }

    override fun onViewClick(view: View) {
        when (view.id) {
            R.id.forgotcontinueTV -> {
            }
            R.id.ivBackpress->{
                baseActivity!!.onBackPressed()
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
        val updatell = dialog.findViewById<LinearLayout>(R.id.updateLL)
        val nameET=dialog.findViewById<EditText>(R.id.editnameET)
        val emailET=dialog.findViewById<EditText>(R.id.editemailET)
        val addressET=dialog.findViewById<EditText>(R.id.editaddressET)
        val nswDriverNumberET=dialog.findViewById<EditText>(R.id.editnswDriverNumberET)
        val dobET=dialog.findViewById<EditText>(R.id.editdobET)

        updatell!!.setOnClickListener {
            if (nameET!!.text!!.isEmpty()){
                showShortToast("Please enter name.")
            }else if (emailET!!.text!!.isEmpty()){
                showShortToast("Please enter email.")
            }else if(addressET!!.text!!.isEmpty()){
                showShortToast("Please enter address.")
            }else if (nswDriverNumberET!!.text.isEmpty()){
                showShortToast("Please enter nsw driver’s license number.")
            }else if (dobET!!.text.isEmpty()){
                showShortToast("Please enter Dob.")
            }else{
                showShortToast("Data Updated")
            }
        }
    }

    override fun onclick(position: Int) {
        val dialog = BottomSheetDialog(requireContext(), R.style.CustomBottomSheetDialogTheme)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.average_ratings_bottom_sheet)
        dialog.show()
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        dialog.behavior.setPeekHeight(0);
        val window = dialog.window
        window!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#00FFFFFF")))
        window.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        window.setGravity(Gravity.BOTTOM)

    }


}