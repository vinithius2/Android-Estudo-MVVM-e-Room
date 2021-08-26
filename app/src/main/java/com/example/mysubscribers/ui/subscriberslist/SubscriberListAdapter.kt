package com.example.mysubscribers.ui.subscriberslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mysubscribers.R
import com.example.mysubscribers.data.db.entity.SubscriberEntity

class SubscriberListAdapter(
    private val subscribers: List<SubscriberEntity>
) : RecyclerView.Adapter<SubscriberViewHolder>() {

    var onItemClick: ((entity: SubscriberEntity) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.subscriber_item, parent, false)
        return SubscriberViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubscriberViewHolder, position: Int) {
        holder.bindView(subscribers[position], onItemClick)
    }

    override fun getItemCount() = subscribers.size

}