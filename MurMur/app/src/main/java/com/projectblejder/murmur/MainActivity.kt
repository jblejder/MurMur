package com.projectblejder.murmur

import android.databinding.DataBindingUtil
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.projectblejder.murmur.databinding.ActivityMainBinding
import com.projectblejder.murmur.domain.KeyConfig
import com.projectblejder.murmur.domain.KeyGenerator
import com.projectblejder.murmur.login.fragments.RegisterFragment
import com.projectblejder.murmur.shared.baseActivity.BaseActivity
import com.projectblejder.murmur.shared.domain.security.factories.AlgorithmParameterSpecFactoryImp
import java.nio.charset.Charset
import java.security.KeyPair
import java.security.PrivateKey
import java.security.PublicKey
import javax.crypto.Cipher

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main);

        var key: KeyPair? = null
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            val keyGenerator = KeyGenerator(AlgorithmParameterSpecFactoryImp())
            key = keyGenerator.generateKey("hej")
        }
        val private: PrivateKey? = key?.private
        val public: PublicKey? = key?.public

        val message: String = "hello!"

        val cipher1 = Cipher.getInstance("RSA/NONE/OAEPwithSHA-256andMGF1Padding")
        cipher1.init(Cipher.ENCRYPT_MODE, public)
        val encripted = cipher1.doFinal(message.toByteArray(Charset.defaultCharset()))

        val cipher2 = Cipher.getInstance("RSA/NONE/OAEPwithSHA-256andMGF1Padding")
        cipher2.init(Cipher.DECRYPT_MODE, private)
        val doFinal = cipher2.doFinal(encripted)
        Log.d("qwe", String(doFinal));

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
