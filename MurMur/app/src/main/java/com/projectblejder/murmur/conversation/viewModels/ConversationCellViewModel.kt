package com.projectblejder.murmur.conversation.viewModels

import android.databinding.ObservableField

class ConversationCellViewModel(val my: Boolean) {

    val text = ObservableField<String>("sort example text")
}
