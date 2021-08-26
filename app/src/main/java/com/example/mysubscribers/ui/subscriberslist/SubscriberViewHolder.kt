package com.example.mysubscribers.ui.subscriberslist

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mysubscribers.data.db.entity.SubscriberEntity
import kotlinx.android.synthetic.main.subscriber_item.view.*

class SubscriberViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    private val textViewSubscriberName: TextView = itemView.text_subscriber_name
    private val textViewSubscriberEmail: TextView = itemView.text_subscriber_email

    fun bindView(subscriber: SubscriberEntity, onItemClick: ((entity: SubscriberEntity) -> Unit)?) {
        textViewSubscriberName.text = subscriber.name
        textViewSubscriberEmail.text = subscriber.email
        itemView.setOnClickListener {
            onItemClick?.invoke(subscriber)
        }
    }

}