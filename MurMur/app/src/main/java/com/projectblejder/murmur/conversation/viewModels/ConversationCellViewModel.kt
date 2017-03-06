package com.projectblejder.murmur.conversation.viewModels

import android.databinding.ObservableField

class ConversationCellViewModel(text: String, val my: Boolean) {

    val text = ObservableField<String>(text)
}
