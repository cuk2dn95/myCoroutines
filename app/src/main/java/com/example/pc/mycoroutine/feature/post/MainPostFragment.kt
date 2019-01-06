package com.example.pc.mycoroutine.feature.post

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pc.mycoroutine.R
import com.example.pc.mycoroutine.architecture.ViewModelFactory
import com.example.pc.mycoroutine.dagger.Injectable
import com.example.pc.mycoroutine.databinding.FragmentAllPostBinding
import javax.inject.Inject

class MainPostFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: MainPostViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentAllPostBinding>(inflater, R.layout.fragment_all_post, container, false)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainPostViewModel::class.java)
        viewModel.layoutManager = LinearLayoutManager(context)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()
        viewModel.getAllPost()
        Log.d("ShareComponent", "${viewModel.data.data} , ${viewModel.data}")
    }

    private fun initComponent() {
    }
}