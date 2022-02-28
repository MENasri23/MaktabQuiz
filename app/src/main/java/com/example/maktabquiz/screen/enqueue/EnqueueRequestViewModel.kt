package com.example.maktabquiz.screen.enqueue

import android.app.Application
import androidx.lifecycle.*
import com.example.maktabquiz.data.model.RepoResponse
import com.example.maktabquiz.data.repository.MyCallback
import com.example.maktabquiz.data.repository.RepoRepository
import com.example.maktabquiz.di.AppContainer


class EnqueueRequestViewModel(
    private val repoRepository: RepoRepository,
    application: Application
) : AndroidViewModel(application) {

    private val repository = AppContainer.repoRepository

    private val _repos = MutableLiveData<RepoResponse>()
    val repos: LiveData<RepoResponse> get() = _repos


    fun listRepos() {
        repoRepository.getRepos("menasri23",
            object : MyCallback<RepoResponse> {
                override fun onResponse(response: RepoResponse) {
                    _repos.postValue(response)
                }

                override fun onFailure(e: Throwable) {

                }
            })
    }

    companion object {
        const val TAG = "EnqueueRequestViewModel"
    }

}