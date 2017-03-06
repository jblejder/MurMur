package com.projectblejder.murmur.conversation.fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.projectblejder.murmur.R
import com.projectblejder.murmur.conversation.ConversationAdapter
import com.projectblejder.murmur.conversation.viewModels.ConversationViewModel
import com.projectblejder.murmur.databinding.ConversationFragmentBinding
import com.projectblejder.murmur.shared.baseActivity.BaseFragment


class ConversationFragment : BaseFragment() {

    val viewModel = ConversationViewModel()

    companion object {
        fun newInstance(): ConversationFragment {
            return ConversationFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<ConversationFragmentBinding>(
                inflater,
                R.layout.conversation_fragment,
                container,
                false)

        binding.recyclerView.adapter = ConversationAdapter(viewModel.feed);
        binding.recyclerView.layoutManager = LinearLayoutManager(context);

        setToolbar(binding.toolbar)

        return binding.root;
    }
}