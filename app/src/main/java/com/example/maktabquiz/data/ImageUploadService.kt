package com.example.maktabquiz.data

import com.example.maktabquiz.data.domain.ImageResponseBody
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ImageUploadService {

    @Multipart
    @POST("/users/{username}")
    fun uploadImage(
        @Path("username") username: String,
        @Part image: MultipartBody.Part
    ): Call<ImageResponseBody>
}