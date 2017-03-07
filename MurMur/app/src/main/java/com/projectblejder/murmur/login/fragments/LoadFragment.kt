package com.projectblejder.murmur.login.fragments

import com.projectblejder.murmur.R
import com.projectblejder.murmur.databinding.LoadFragmentBinding
import com.projectblejder.murmur.shared.baseActivity.BaseFragment

class LoadFragment : BaseFragment<LoadFragmentBinding>(){
    override val layoutId = R.layout.load_fragment

    companion object {
        fun newInstance(): LoadFragment {
            return LoadFragment()
        }
    }
}