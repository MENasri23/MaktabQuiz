package com.example.maktabquiz.data.repository

import com.example.maktabquiz.data.model.RepoResponse

class RepoRepository(
    private val remoteDataSource: RepoDataSource<RepoResponse>
) {

    fun getRepos(username: String, callback: MyCallback<RepoResponse>) {
        remoteDataSource.getRepos(username, callback)
    }
}