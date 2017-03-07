package com.projectblejder.murmur

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import com.projectblejder.murmur.databinding.ActivityMainBinding
import com.projectblejder.murmur.login.fragments.RegisterFragment
import com.projectblejder.murmur.shared.baseActivity.BaseActivity

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main);

        val tr = supportFragmentManager.beginTransaction()
        tr.replace(binding.container.id, RegisterFragment.newInstance());
        tr.commit();
    }

    fun openFragment(fragment: Fragment) {
        val tr = supportFragmentManager.beginTransaction()
        tr.replace(binding.container.id, RegisterFragment.newInstance());
        tr.commit();
    }
}
