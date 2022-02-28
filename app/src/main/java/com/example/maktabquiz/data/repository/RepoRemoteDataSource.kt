package com.example.maktabquiz.data.repository

import com.example.maktabquiz.data.GithubService
import com.example.maktabquiz.data.model.RepoResponse
import retrofit2.*

class RepoRemoteDataSource(
    private val service: GithubService
) : RepoDataSource<RepoResponse> {

    override fun getRepos(username: String, callback: MyCallback<RepoResponse>) {
        service.listRepos(username).enqueue(object : Callback<RepoResponse?> {
            override fun onResponse(call: Call<RepoResponse?>, response: Response<RepoResponse?>) {
                response.body()?.let {
                    callback.onResponse(it)
                }
            }

            override fun onFailure(call: Call<RepoResponse?>, t: Throwable) {
                callback.onFailure(t)
            }
        })
    }
}