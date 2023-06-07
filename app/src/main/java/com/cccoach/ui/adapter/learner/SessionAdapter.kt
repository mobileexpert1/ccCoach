package com.cccoach.ui.adapter.learner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cccoach.R
import com.cccoach.databinding.ItemSessionsBinding


class SessionAdapter(val context: Context) : RecyclerView.Adapter<SessionAdapter.ViewHolder>(){

    private lateinit var binding: ItemSessionsBinding

    // This method returns our layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_sessions, parent, false)

        return ViewHolder(binding.root)
    }

    // This method binds the screen with the view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // This will set the images in imageview

    }

    // This Method returns the size of the Array
    override fun getItemCount(): Int {
        return 4
    }

    // The ViewHolder class holds the view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}