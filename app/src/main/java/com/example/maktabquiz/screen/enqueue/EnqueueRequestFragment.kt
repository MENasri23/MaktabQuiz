package com.example.maktabquiz.screen.enqueue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.maktabquiz.databinding.EnqueueRequestFragmentBinding

class EnqueueRequestFragment : Fragment() {


    private val viewModel by viewModels<EnqueueRequestViewModel>()

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

    override fun onStart() {
        super.onStart()
        viewModel.load()
    }


}