package com.example.maktabquiz.data.repository


interface MyCallback<T> {

    fun onResponse(response: T)

    fun onFailure(e: Throwable)
}