package com.learnings.github.chatui.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    val isLoading: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply {
        postValue(false)
    }

    protected val messageStringIdLiveData: MutableLiveData<Int> = MutableLiveData()

    protected val messageStringLiveData: MutableLiveData<String> = MutableLiveData()

    override fun onCleared() {
        super.onCleared()
    }

}