package com.example.maktabquiz.data

import com.example.maktabquiz.data.domain.ImageResponseBody
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL = "http://51.195.19.222/"
    private val okHttpClient = OkHttpClient.Builder()
        .callTimeout(15, TimeUnit.SECONDS)
        .addInterceptor(NetworkManger.createLoggingInterceptor())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val service = retrofit.create(ImageUploadService::class.java)


    inline fun uploadImage(
        username: String,
        crossinline providePart: () -> MultipartBody.Part
    ): Call<ImageResponseBody> {
        return service.uploadImage(username, providePart())
    }

    inline fun <T : Any> Call<T>.enqueue(
        crossinline onFailure: (Call<T>, error: Throwable) -> Unit = { _, _ -> },
        crossinline onResponse: (call: Call<T>, response: Response<T>) -> Unit
    ) {
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                onResponse(call, response)
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                onFailure(call, t)
            }
        })
    }

}