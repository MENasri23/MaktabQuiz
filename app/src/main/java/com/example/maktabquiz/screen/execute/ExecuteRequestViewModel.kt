package com.example.maktabquiz.screen.execute

import android.app.Application
import androidx.lifecycle.*
import okhttp3.Request

class ExecuteRequestViewModel(application: Application) : AndroidViewModel(application) {

    private val _response = MutableLiveData<String?>(null)
    val response: LiveData<String?> get() = _response


    fun load() {
        val request = Request.Builder().url(NetworkManger.URL).build()
//        Client.execute(request) { response ->
//            _response.postValue(response)
//        }

        NetworkManger.executeWithHandler(
            context = getApplication<Application>().applicationContext,
            request = request
        ) {
            _response.value = it
        }
    }
}