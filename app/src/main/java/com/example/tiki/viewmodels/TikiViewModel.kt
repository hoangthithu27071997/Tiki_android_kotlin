package com.example.tiki.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tiki.models.Tiki

class TikiViewModel : ViewModel()  {

    val getDataTiki = MutableLiveData<Tiki>()
    init {
        getDataTiki.value = Tiki.mock()
    }
}