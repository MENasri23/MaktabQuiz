package com.example.maktabquiz.screen.enqueue

import android.app.Application
import androidx.lifecycle.*
import com.example.maktabquiz.data.RetrofitClient
import android.R.id
import android.provider.MediaStore
import android.util.Log
import com.example.maktabquiz.data.RetrofitClient.enqueue
import com.example.maktabquiz.data.domain.ImageResponseBody
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody


class EnqueueRequestViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String> get() = _response


    fun load() {
        RetrofitClient.uploadImage(
            "mohsenafshar",
            providePart = {
                val imageFile =
                    getApplication<Application>().assets.open("image.png").readBytes()

                // MultipartBody.Part is used to send also the actual file name
                val imageRequestBody = imageFile.toRequestBody("image/*".toMediaTypeOrNull())

                // MultipartBody.Part is used to send also the actual file name
                MultipartBody.Part.createFormData("image", "mathmatics", imageRequestBody)

            }
        ).enqueue { _, response ->
            response.body()?.let {
                Log.d(TAG, it.pathParams.username)
            }

        }
    }

    companion object {
        const val TAG = "EnqueueRequestViewModel"
    }

}