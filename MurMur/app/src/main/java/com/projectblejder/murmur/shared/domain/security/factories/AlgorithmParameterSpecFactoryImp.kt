package com.projectblejder.murmur.shared.domain.security.factories

import android.annotation.TargetApi
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import com.projectblejder.murmur.domain.AlgorithmParameterSpecFactory
import java.security.spec.AlgorithmParameterSpec
import java.security.spec.RSAKeyGenParameterSpec

@TargetApi(23)
class AlgorithmParameterSpecFactoryImp : AlgorithmParameterSpecFactory {

    override fun create(alias: String): AlgorithmParameterSpec {
        return KeyGenParameterSpec.Builder(alias, KeyProperties.PURPOSE_DECRYPT)
                .setDigests(KeyProperties.DIGEST_SHA256, KeyProperties.DIGEST_SHA512)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_RSA_OAEP)
                .build()
    }
}