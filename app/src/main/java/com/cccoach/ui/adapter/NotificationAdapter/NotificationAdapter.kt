package com.cccoach.ui.adapter.NotificationAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cccoach.R
import com.cccoach.databinding.NotificationItemsBinding

class NotificationAdapter(val context: Context,private var listener: NotificationAdapter.ClickListeners) : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    private lateinit var binding: NotificationItemsBinding

    interface ClickListeners {
        fun onclick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.notification_items, parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}