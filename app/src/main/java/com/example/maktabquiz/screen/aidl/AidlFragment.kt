package com.example.maktabquiz.screen.aidl

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.maktabquiz.R
import com.example.maktabquiz.databinding.AidlFragmentBinding

class AidlFragment : Fragment(R.layout.aidl_fragment) {

    private lateinit var viewModel: AidlViewModel
    private lateinit var binding: AidlFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(AidlViewModel::class.java)
        return inflater.inflate(R.layout.aidl_fragment, container, false)
    }


}