package com.projectblejder.murmur.shared.baseActivity

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    abstract val layoutId: Int

    lateinit var binding: T
        private set

    open fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?) {}

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.binding = DataBindingUtil.inflate<T>(inflater, layoutId, container, false)
        initView(inflater, container, savedInstanceState)
        return this.binding.root
    }

    fun setToolbar(toolbar: Toolbar) {
        (activity as BaseActivity).setSupportActionBar(toolbar)
    }
}