package com.projectblejder.murmur.conversation.adapters

import android.databinding.ObservableList
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.projectblejder.murmur.conversation.viewModels.ConversationCellViewModel
import com.projectblejder.murmur.databinding.ConversationMyMessageCellBinding
import com.projectblejder.murmur.databinding.ConversationTheirMessageListviewBinding

class ConversationAdapter(dataSet: ObservableList<ConversationCellViewModel>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val feed: ObservableList<ConversationCellViewModel> = dataSet

    override fun getItemViewType(position: Int): Int {
        return if (feed.get(position).my) 0 else 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder: RecyclerView.ViewHolder
        if (viewType == 0) {
            val binding = ConversationMyMessageCellBinding.inflate(inflater)
            viewHolder = MyMessageViewHolder(binding)
        } else {
            val binding = ConversationTheirMessageListviewBinding.inflate(inflater)
            viewHolder = TherMessageViewHolder(binding)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is MyMessageViewHolder) {
            holder.model = feed.get(position)
        } else if (holder is TherMessageViewHolder) {
            holder.model = feed.get(position)
        }
    }

    override fun getItemCount(): Int {
        return feed.size
    }

    class MyMessageViewHolder(val binding: ConversationMyMessageCellBinding)
        : RecyclerView.ViewHolder(binding.root) {

        var model: ConversationCellViewModel? = null
            set(value) {
                this.binding.model = value
            }
    }

    class TherMessageViewHolder(val binding: ConversationTheirMessageListviewBinding)
        : RecyclerView.ViewHolder(binding.root) {

        var model: ConversationCellViewModel? = null
            set(value) {
                this.binding.model = value
            }
    }
}