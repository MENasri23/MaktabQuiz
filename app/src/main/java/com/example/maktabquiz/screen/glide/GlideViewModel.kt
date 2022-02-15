package com.example.maktabquiz.screen.glide

import androidx.lifecycle.*

class GlideViewModel : ViewModel() {


    private val _firstUrl = MutableLiveData("https://picsum.photos/seed/orange/200/300")
    val firstUrl: LiveData<String?> get() = _firstUrl

    private val _secondUrl = MutableLiveData("https://picsum.photos/seed/yellow/200/300")
    val secondUrl: LiveData<String?> get() = _secondUrl

    private val _thirdUrl = MutableLiveData("https://picsum.photos/seed/pink/200/300")
    val thirdUrl: LiveData<String?> get() = _thirdUrl

    private val _forthUrl = MutableLiveData("https://picsum.photos/seed/blue/200/300")
    val forthUrl: LiveData<String?> get() = _forthUrl


}