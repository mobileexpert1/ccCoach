package com.cccoach.ui.fragments.timebooking

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cccoach.databinding.FragmentTimeBookingBinding
import com.cccoach.ui.adapter.availabilityslots.AvailabilitySlotsAdapter
import com.cccoach.ui.base.BaseAdapter
import com.cccoach.ui.base.BaseFragment
import com.cccoach.utils.Const

class TimeBookingFragment : BaseFragment(), BaseAdapter.OnItemClickListener {


    var binding:FragmentTimeBookingBinding?=null
    private var slotsAdapter: AvailabilitySlotsAdapter? = null


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
            binding = FragmentTimeBookingBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {
//        binding!!.handleClick = this
        setSlotsAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setSlotsAdapter() {
//        slotsAdapter = AvailabilitySlotsAdapter(baseActivity!!, slotsViewModel!!.slotsList)
//        binding?.slotsRV?.adapter = slotsAdapter
//        slotsAdapter!!.setOnItemClickListener(this)

    }


    companion object {

    }

    override fun onItemClick(vararg itemData: Any) {
        if (itemData.isNotEmpty()) {
            val type = itemData[1] as Int
            val pos = itemData[0] as Int
            when (type) {
                Const.Slots.SELECT_SLOTS -> {

                }

            }

        }

    }

}