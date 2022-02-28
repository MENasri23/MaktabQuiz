package com.example.maktabquiz.screen.enqueue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.maktabquiz.databinding.EnqueueRequestFragmentBinding
import com.example.maktabquiz.di.AppContainer

class EnqueueRequestFragment : Fragment() {


    private val viewModel by viewModels<EnqueueRequestViewModel>(
        factoryProducer = {
            EnqueueViewModelFactory(
                AppContainer.repoRepository,
                requireActivity().application
            )
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = EnqueueRequestFragmentBinding.inflate(
            inflater, container, false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }


}