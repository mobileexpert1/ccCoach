package com.cccoach.ui.adapter.Favourite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cccoach.R
import com.cccoach.databinding.ItemCoachBinding


class FavouriteAdapter(val context: Context, private var listener: ClickListeners) : RecyclerView.Adapter<FavouriteAdapter.ViewHolder>() {

    private lateinit var binding: ItemCoachBinding
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    interface ClickListeners {
        fun onclick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_coach, parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.setOnClickListener { listener.onclick(position) }

    }

    override fun getItemCount(): Int {
        return 5
    }


}