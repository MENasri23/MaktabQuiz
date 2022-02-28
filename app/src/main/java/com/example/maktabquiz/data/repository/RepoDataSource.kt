package com.example.maktabquiz.data.repository

import com.example.maktabquiz.data.model.RepoResponse

interface RepoDataSource<T> {

    fun getRepos(username :String, callback: MyCallback<T>)
}