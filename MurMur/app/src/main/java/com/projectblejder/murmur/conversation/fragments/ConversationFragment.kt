package com.projectblejder.murmur.conversation.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import com.projectblejder.murmur.R
import com.projectblejder.murmur.conversation.adapters.ConversationAdapter
import com.projectblejder.murmur.conversation.viewModels.ConversationViewModel
import com.projectblejder.murmur.databinding.ConversationFragmentBinding
import com.projectblejder.murmur.shared.baseActivity.BaseFragment


class ConversationFragment : BaseFragment<ConversationFragmentBinding>(), ConversationFragmentHandler {

    override val layoutId = R.layout.conversation_fragment

    val viewModel = ConversationViewModel()

    companion object {
        fun newInstance(): ConversationFragment {
            return ConversationFragment()
        }
    }

    override fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?) {
        binding.model = viewModel
        binding.handler = this

        binding.recyclerView.adapter = ConversationAdapter(viewModel.feed)
        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, true)

        setToolbar(binding.toolbar)
    }

    override fun sendButtonClick() {
        viewModel.executeSendMessage()
    }
}