package com.projectblejder.murmur.shared.baseActivity

import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar

abstract class BaseFragment : Fragment() {

    fun setToolbar(toolbar: Toolbar) {
        (activity as BaseActivity).setSupportActionBar(toolbar)
    }
}