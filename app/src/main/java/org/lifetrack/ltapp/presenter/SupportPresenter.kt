package org.lifetrack.ltapp.presenter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SupportPresenter: ViewModel() {
    var version by mutableStateOf("2.0.0")
        private set

    fun onVersionChange(value: String){
        version = value
    }
}