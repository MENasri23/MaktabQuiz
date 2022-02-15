package com.example.maktabquiz.screen.enqueue

import android.app.Application
import androidx.lifecycle.*
import com.example.maktabquiz.data.Client
import okhttp3.*
import java.io.IOException

class EnqueueRequestViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String> get() = _response


    fun load() {
        Client.enqueue(
            request = { url(Client.URL) },
            callback = object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    _response.postValue(e.message)
                }

                override fun onResponse(call: Call, response: Response) {
                    _response.postValue(response.body?.string())
                }
            })
    }

}