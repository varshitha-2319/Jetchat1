package com.example.compose.jetchat.conversation
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.compose.jetchat.databinding.FragmentNewchatBinding
import com.example.compose.jetchat.conversation.newchat.NewChatMessage
import com.example.compose.jetchat.conversation.newchat.MessageAdapter

class NewchatFragment : Fragment() {

    private var _binding: FragmentNewchatBinding? = null
    private val binding get() = _binding!!

    // Updated sampleMessages with correct data type
    private val sampleMessages = listOf(
        NewChatMessage("Alice", "Hey! How's it going?", "10:30 AM"),
        NewChatMessage("Bob", "I'm good! What about you?", "10:32 AM"),
        NewChatMessage("Alice", "All good here. Let's catch up soon!", "10:34 AM"),
        NewChatMessage("Bob", "Sure, sounds great!", "10:35 AM")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewchatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = MessageAdapter(sampleMessages)  // Corrected Adapter Reference
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
