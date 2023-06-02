package com.cccoach.ui.fragments.FindACoach

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cccoach.R
import com.cccoach.databinding.FragmentFindACoachBinding
import com.cccoach.model.slotdata.SlotData
import com.cccoach.ui.activities.MainActivity
import com.cccoach.ui.adapter.availabilityslots.AvailabilitySlotsAdapter
import com.cccoach.ui.base.BaseAdapter
import com.cccoach.ui.base.BaseFragment
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.fragments.Learner.coaches.CoachesFragment
import com.cccoach.utils.Const
import com.cccoach.utils.HandleClickListener


class FindACoachFragment : BaseFragment(),HandleClickListener, BaseAdapter.OnItemClickListener {

    var binding:FragmentFindACoachBinding?=null
    private var slotsAdapter: AvailabilitySlotsAdapter? = null
    var slotsListData: ArrayList<SlotData>?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null)
            binding = FragmentFindACoachBinding.inflate(inflater, container, false)
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
        slotsListData=ArrayList<SlotData>()
        setSlotsAdapter()
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setSlotsAdapter() {
//        for (i in 0 until 10) {
            slotsListData!!.add(SlotData("8:00 AM-9:00 AM"))
            slotsListData!!.add(SlotData("9:00 AM-10:00 AM"))
            slotsListData!!.add(SlotData("10:00 AM-11:00 AM"))
            slotsListData!!.add(SlotData("11:00 AM-12:00 PM"))
            slotsListData!!.add(SlotData("12:00 PM-1:00 PM"))
            slotsListData!!.add(SlotData("1:00 PM-2:00 PM"))
            slotsListData!!.add(SlotData("2:00 PM-3:00 PM"))
            slotsListData!!.add(SlotData("3:00 PM-4:00 PM"))
            slotsListData!!.add(SlotData("4:00 PM-5:00 PM"))
            slotsListData!!.add(SlotData("5:00 PM-6:00 PM"))
            slotsListData!!.add(SlotData("6:00 PM-7:00 PM"))
//        }
        slotsAdapter = AvailabilitySlotsAdapter(baseActivity!!, slotsListData!!)
        binding?.slotsRV?.adapter = slotsAdapter
        slotsAdapter!!.setOnItemClickListener(this)

    }

    override fun onViewClick(view: View) {

        when (view.id) {
            R.id.ivBackpress->{
                requireActivity().supportFragmentManager.popBackStack()
            }
            R.id.findCoachesTV->{
                gotoCoaches()
            }
        }
    }

    private fun gotoCoaches() {
        baseActivity!!.replaceFragment(CoachesFragment(), R.id.frame_container)
    }

    override fun onItemClick(vararg itemData: Any) {
        if (itemData.isNotEmpty()) {
            val type = itemData[1] as Int
            val pos = itemData[0] as Int
            when (type) {
                Const.Slots.SELECT_SLOTS -> {
                    slotsAdapter!!.notifyItemChanged(pos)

                }

            }

        }


    }

}