package com.cccoach.ui.adapter.ContactUs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cccoach.R
import android.content.Context


class ContactUsAdapter(val context: Context,private var listener: ClickListeners) : RecyclerView.Adapter<ContactUsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.contactus_tickets_items, parent, false)
        return ViewHolder(view)
    }

    interface ClickListeners {
        fun onclick(position: Int)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener { listener.onclick(position) }
    }

    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}