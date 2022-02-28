package com.example.maktabquiz.data

import com.example.maktabquiz.data.model.RepoResponse
import retrofit2.Call
import retrofit2.http.*

interface GithubService {

    @GET("users/{username}/repos")
    fun listRepos(@Path("username") username: String): Call<RepoResponse>


}