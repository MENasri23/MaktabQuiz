package com.example.maktabquiz.di

import com.example.maktabquiz.data.repository.RepoRemoteDataSource
import com.example.maktabquiz.data.repository.RepoRepository

object AppContainer {

    val repoRepository = RepoRepository(
        RepoRemoteDataSource(RetrofitClient.service)
    )
}