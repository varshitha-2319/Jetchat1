package com.example.compose.jetchat.conversation.newchat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.compose.jetchat.databinding.ItemMessageBinding

class MessageAdapter(private val messages: List<NewChatMessage>) :
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    inner class MessageViewHolder(private val binding: ItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: NewChatMessage) {
            binding.senderName.text = message.sender     // ✅ Corrected reference
            binding.messageBody.text = message.message   // ✅ Corrected reference
            binding.timestamp.text = message.timestamp   // ✅ Corrected reference
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val binding = ItemMessageBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messages[position])
    }

    override fun getItemCount(): Int = messages.size
}
