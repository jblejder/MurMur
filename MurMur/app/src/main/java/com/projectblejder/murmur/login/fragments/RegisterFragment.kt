package com.projectblejder.murmur.login.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.projectblejder.murmur.R
import com.projectblejder.murmur.databinding.RegisterFragmentBinding
import com.projectblejder.murmur.login.viewModels.RegisterViewModel
import com.projectblejder.murmur.shared.baseActivity.BaseFragment

class RegisterFragment : BaseFragment<RegisterFragmentBinding>() {
    override val layoutId = R.layout.register_fragment

    val viewModel = RegisterViewModel()

    companion object {
        fun newInstance(): RegisterFragment {
            return RegisterFragment()
        }
    }

    override fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?) {
        binding.setModel(viewModel)
        binding.setHandler(ViewHandler())
    }

    private inner class ViewHandler : RegisterHandler {

        override fun onRegisterClick() {
            viewModel.executeRegister()
        }
    }
}