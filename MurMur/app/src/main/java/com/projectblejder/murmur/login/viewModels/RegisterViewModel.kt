package com.projectblejder.murmur.login.viewModels

import android.databinding.ObservableField
import com.projectblejder.murmur.domain.CreateUser
import com.projectblejder.murmur.domain.CreateUserModel
import timber.log.Timber

class RegisterViewModel {

    val login = ObservableField<String>();
    val password = ObservableField<String>();

    fun executeRegister() {
        val user = CreateUser().createUser(CreateUserModel(login.get(), password.get()))
        Timber.d("l: %s p: %s", user.login, user.hash);
    }
}