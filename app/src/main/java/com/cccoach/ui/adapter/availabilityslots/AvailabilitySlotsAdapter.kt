package com.cccoach.ui.adapter.availabilityslots

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.cccoach.R
import com.cccoach.databinding.AdapterAvailabilitySlotsBinding
import com.cccoach.model.slotdata.SlotData
import com.cccoach.ui.base.BaseActivity
import com.cccoach.ui.base.BaseAdapter
import com.cccoach.ui.base.BaseViewHolder
import com.cccoach.utils.Const

class AvailabilitySlotsAdapter(
    private var baseActivity: BaseActivity,
//    private val slotsList: MutableLiveData<ArrayList<SlotData>>,
    private val slotsList: ArrayList<SlotData>,
) : BaseAdapter() {

    var selectedPosition = -1
    var lastSelectedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = DataBindingUtil.inflate<AdapterAvailabilitySlotsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.adapter_availability_slots,
            parent,
            false
        )
        return BaseViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return slotsList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val binding = holder.binding as AdapterAvailabilitySlotsBinding
        val data = slotsList[position]
        binding.timeTV.text = data.slotTimes
        binding.timeTV.background =
            ContextCompat.getDrawable(baseActivity, R.drawable.bg_grey_stroke)
        binding.timeTV.setTextColor(
            ContextCompat.getColor(
                baseActivity,
                R.color.black
            )
        )

        if (selectedPosition == position) {
            binding.timeTV.background =
                ContextCompat.getDrawable(baseActivity, R.drawable.darkblue_rect)
            binding.timeTV.setTextColor(ContextCompat.getColor(baseActivity, R.color.White))
        } else {
            binding.timeTV.background =
                ContextCompat.getDrawable(baseActivity, R.drawable.bg_grey_stroke)
            binding.timeTV.setTextColor(
                ContextCompat.getColor(
                    baseActivity,
                    R.color.black
                )
            )

        }

        binding.root.setOnClickListener {
            onItemClick(
                position,
                Const.Slots.SELECT_SLOTS
            )
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }

    }

}
