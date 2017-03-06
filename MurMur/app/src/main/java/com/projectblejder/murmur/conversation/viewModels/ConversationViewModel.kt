package com.projectblejder.murmur.conversation.viewModels

import android.databinding.ObservableArrayList
import android.databinding.ObservableField

class ConversationViewModel {

    val feed = ObservableArrayList<ConversationCellViewModel>();
    val newMessageText = ObservableField<String>();


    fun executeSendMessage() {
        val text = newMessageText.get()
        feed.add(ConversationCellViewModel(text, true))
        newMessageText.set("");
    }
}