package com.cccoach.ui.adapter.Message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cccoach.R
private const val VIEW_TYPE_MY_MESSAGE = 1
private const val VIEW_TYPE_OTHER_MESSAGE = 2

class ChatMessageAdapter(val context: Context) : RecyclerView.Adapter<ChatMessageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return  if(viewType == VIEW_TYPE_MY_MESSAGE) {
          ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_chat, parent, false))
        } else {
          ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_chat, parent, false))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}