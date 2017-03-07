package com.projectblejder.murmur

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.projectblejder.murmur.databinding.ActivityMainBinding
import com.projectblejder.murmur.login.fragments.RegisterFragment
import com.projectblejder.murmur.shared.baseActivity.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main);

        val tr = supportFragmentManager.beginTransaction()
        tr.replace(binding.container.id, RegisterFragment.newInstance());
        tr.commit();
    }
}
