package com.example.maktabquiz.screen.enqueue

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.maktabquiz.data.model.RepoResponse
import com.example.maktabquiz.data.repository.RepoRepository
import java.lang.IllegalArgumentException

class EnqueueViewModelFactory(
    private val repoRepository: RepoRepository,
    private val application: Application
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EnqueueRequestViewModel::class.java)) {
            return EnqueueRequestViewModel(repoRepository, application) as T
        }

        return modelClass.newInstance()
    }
}