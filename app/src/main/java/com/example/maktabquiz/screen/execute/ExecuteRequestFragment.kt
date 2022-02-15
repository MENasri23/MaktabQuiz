package com.example.maktabquiz.screen.execute

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.maktabquiz.databinding.ExecuteRequestFragmentBinding

class ExecuteRequestFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(this)
            .get(ExecuteRequestViewModel(requireActivity().application)::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = ExecuteRequestFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }


    override fun onStart() {
        super.onStart()
        viewModel.load()
    }

}